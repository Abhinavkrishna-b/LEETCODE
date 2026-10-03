//Refer leetcode notes to important edge case those are very important
//Note we need to check only for "4-directionally adjacent" top,bottom,left,right (diagonals not included)
class Solution {
    public int orangesRotting(int[][] grid) {
        //Here dfs will not work as it says we need minimum no of miniutes so use bfs
        //Shortest Path or Minimum Steps - use BFS
        //Exhaustive Search & All Paths -DFS
        if(grid.length == 0)    return 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>(); //Array is a object not a primitive datatype 

        //Adding the intial set of rotten oranges and count total fresh oranges
        int freshCount = 0;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c] == 1){
                    freshCount++;
                }
                if(grid[r][c] == 2){
                    queue.add(new int[] {r,c});
                }
            }
        }

        if(freshCount == 0) return 0;
        //Now track the oranges that is gonna be rotten
        int time = 0;
        while(!queue.isEmpty() && freshCount > 0){
            //for each element in the queue we need to pop it and also add the adjacent fresh oranges that is gone rotten next
            time++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                int rm[] = queue.remove();
                //for each rotten orange we see the top,bottom,left,right if fresh orange present
                int R = rm[0], C = rm[1];
                //Top
                if(R > 0 && grid[R-1][C] == 1){
                    queue.add(new int[] {R-1,C} );
                    freshCount--;
                    //Important change the freshOrange to rotten
                    grid[R-1][C] = 2;
                }
                //Bottom
                if(R<grid.length-1 && grid[R+1][C] == 1){
                    queue.add(new int[] {R+1,C} );
                    freshCount--;
                    grid[R+1][C] = 2;
                }
                //Left
                if(C>0 && grid[R][C-1] == 1){
                    queue.add(new int[] {R,C-1} );
                    freshCount--;
                    grid[R][C-1] = 2;
                }
                if(C<grid[0].length-1 && grid[R][C+1] == 1){
                    queue.add(new int[] {R,C+1} );
                    freshCount--;
                    grid[R][C+1] = 2;
                }
            }
        }
        if(freshCount == 0){
            return time;
        }
        else{
            return -1;
        }
    }
}
//Time- O(rc)
//Space- O(rc)
