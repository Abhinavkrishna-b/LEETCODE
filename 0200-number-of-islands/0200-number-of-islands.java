class Solution {
    public int numIslands(char[][] grid) {
        //You can either use a extra space visited[][] or just mark the seen 1's as 0's
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    backtrack(grid, i, j);
                }
            }
        }
        return count;
    }

    //You already made the count++ so here just set the island 1's to 0's
    public void backtrack(char grid[][], int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length){
            return;
        }
        if(grid[r][c] == '0'){
            return;
        }
        if(grid[r][c] == '1'){
            grid[r][c] = '0';
            backtrack(grid, r-1, c);
            backtrack(grid, r+1, c);
            backtrack(grid, r, c-1);
            backtrack(grid, r, c+1);
            //Here you can use return but anyway the function is over it is gona return
        }
    }
}
//Time- O(rc) 
//as recursion time complexity is constant. Each cell is visited at most once by DFS.
//Space- O(rc)
