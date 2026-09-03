class Solution {
    public int islandPerimeter(int[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return perimeter(grid, visited, i, j);
                }
            }
        }
        return 0;
    }

    public int perimeter(int grid[][],int visited[][], int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length){
            return 1;
        }
        if(grid[r][c] == 0){
            return 1;
        }
        if(visited[r][c] == 1){
            return 0;
        }
        visited[r][c] = 1;
        int result = perimeter(grid, visited, r+1, c) + perimeter(grid, visited, r-1, c) + perimeter(grid, visited, r, c+1) + perimeter(grid, visited, r, c-1);

        return result;
    }
}
//Time- O(rc) and here the recursion time complexity is constant as each path of 1 is visited only once
//Space- O(rc)