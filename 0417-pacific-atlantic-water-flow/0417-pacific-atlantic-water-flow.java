//The problem says that from each cell in the grid (represent height) consider it is raining and each cell also has water. You need to know if from a particular cell can we reach the both pacific ocean and atlantic ocean
//Refer neetcode
class Solution {
    //trying dfs on each cell kinda difficult so 
    //Do dfs for (pacific ocean to atlantic ocean) left and top
    //Also do dfs for (atlantic ocean to pacific ocean) right and down
    //we also need to do for both because of some cells in the corners
    //Basically it is like we mark all the nodes in path of atlantic and pacific if a node is both visited by atlantic and pacific then it is valid
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        //Visited paths from oceans
        boolean pacificVisited[][] = new boolean[heights.length][heights[0].length];
        boolean atlanticVisited[][] = new boolean[heights.length][heights[0].length];

        //The top and bottom
        for(int i=0;i<heights[0].length;i++){
            dfs(heights, pacificVisited, 0, i, Integer.MIN_VALUE);//Top
            dfs(heights, atlanticVisited, heights.length-1, i, Integer.MIN_VALUE);//Bottom
        }

        //The left and right
        for(int i=0;i<heights.length;i++){
            dfs(heights, pacificVisited, i, 0, Integer.MIN_VALUE);//Left
            dfs(heights, atlanticVisited, i, heights[0].length-1, Integer.MIN_VALUE);//Right
        }

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacificVisited[i][j] == true && atlanticVisited[i][j] == true){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public void dfs(int heights[][], boolean visited[][], int r, int c, int prevHeight){
        //Our goal of dfs is just to mark the path of oceans
        if(r<0 || c<0 || r>=heights.length || c>=heights[0].length || heights[r][c] < prevHeight || visited[r][c] == true){
            //Note from the ocean the height goes increasing along the path
            return;
        }
        //Note changing the val here will reflect in original
        visited[r][c] = true;
        dfs(heights, visited, r-1, c, heights[r][c]);
        dfs(heights, visited, r+1, c, heights[r][c]);
        dfs(heights, visited, r, c-1, heights[r][c]);
        dfs(heights, visited, r, c+1, heights[r][c]);
    }
}
//Time- O(2rc) ~ O(rc)
//Space- O(rc)
