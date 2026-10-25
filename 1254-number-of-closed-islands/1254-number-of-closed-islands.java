class Solution {
    public int closedIsland(int[][] grid) {
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    boolean isIsland = dfs(grid, i, j);
                    if(isIsland){
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public boolean dfs(int grid[][], int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length){
            return false;
        }
        if(grid[r][c] == 1){
            return true;
        }
        //Use a visited array or just update that cell
        grid[r][c] = 1;

        //The important lesson from my experience - whenever you use || , && it has some edge case (short circuit)
        //Like here If the left side is false, don't execute the right side - So visited array will me not marked for that
        //So make a seperate variable for each direction so everything runs
        boolean top = dfs(grid, r-1,c);
        boolean bottom = dfs(grid, r+1, c);
        boolean left = dfs(grid, r, c-1);
        boolean right = dfs(grid, r, c+1);
        
        return top && bottom && left && right;
    }
}
//Time- O(rc)
//Space- O(rc)