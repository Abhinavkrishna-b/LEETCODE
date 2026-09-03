class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    island(grid, i, j);
                }
            }
        }
        return count;
    }

    public void island(char grid[][], int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == '0'){
            return;
        }
        if(grid[r][c] == '1'){
            grid[r][c] = '0';
        }
        island(grid, r-1, c);
        island(grid, r+1, c);
        island(grid, r, c-1);
        island(grid, r, c+1);
        return;
    }
}
//Time- O(rc) 
//as recursion time complexity is constant. Each cell is visited at most once by DFS.
//Space- O(rc)