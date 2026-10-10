//BFS
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //Put Integer.MAX_VALUE for unvisited vertex
        Queue<int []> queue = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    queue.add(new int[] {i,j});
                    continue;
                }
                mat[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!queue.isEmpty()){
            int rm[] = queue.remove();
            int R = rm[0], C = rm[1];
            //You only visit the unvisisted vertex
            if(R>0 && mat[R-1][C] == Integer.MAX_VALUE){
                mat[R-1][C] = mat[R][C] + 1;
                queue.add(new int[] {R-1,C});
            }
            if(R<mat.length-1 && mat[R+1][C] == Integer.MAX_VALUE){
                mat[R+1][C] = mat[R][C] + 1;
                queue.add(new int[] {R+1,C});
            }
            if(C>0 && mat[R][C-1] == Integer.MAX_VALUE){
                mat[R][C-1] = mat[R][C] + 1;
                queue.add(new int[] {R,C-1});
            }
            if(C<mat[0].length-1 && mat[R][C+1] == Integer.MAX_VALUE){
                mat[R][C+1] = mat[R][C] + 1;
                queue.add(new int[] {R,C+1});
            }
        }
        return mat;
    }
}
//Time- O(rc)
//Space- O(rc)