class Solution {
    public int islandPerimeter(int[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    //As there is only one island exactly
                    return Perimeter(grid,i,j,visited);
                }
            }
        }
        return 0;
    }

    public int Perimeter(int grid[][], int r, int c, int visited[][]){
        if(r >= grid.length || c >= grid[0].length || r<0 || c<0 || grid[r][c] == 0){
            return 1;
        }
        if(visited[r][c] == 1){
            return 0;
        }

        int result = 0;
        visited[r][c] = 1;
        result += Perimeter(grid,r-1,c,visited);//Going up
        result += Perimeter(grid,r+1,c,visited); //Going down
        result += Perimeter(grid,r, c-1,visited);//Going left
        result += Perimeter(grid,r,c+1,visited);//Going right
        return result;
    }
}
//Time- O(rc)+O(rc) ~ O(rc)
//Space- O(rc)