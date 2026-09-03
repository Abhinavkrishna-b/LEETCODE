class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, calculateArea(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int calculateArea(int grid[][], int r, int c){
        int count = 0;
        if(r>=grid.length || c>=grid[0].length || r<0 || c<0 || grid[r][c] == 0){
            return count;
        }
        if(grid[r][c] == 1){
            count++;
        }
        grid[r][c] = 0;
        count += calculateArea(grid, r+1, c);
        count += calculateArea(grid, r-1, c);
        count += calculateArea(grid, r, c+1);
        count += calculateArea(grid, r, c-1);

        return count;
    }
}
//Time- O(rc) and recursion time complexity is constant O(4) ~ O(1)
//Space- O(rc)
