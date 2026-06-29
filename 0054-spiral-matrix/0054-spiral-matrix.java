class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        ArrayList<Integer> res = new ArrayList<>();
        int left=0, right=n-1;
        int top=0,bottom=m-1;

        while(top <= bottom && left <= right){

            //Left->right;
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;

            //Top->bottom
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;

            if(left > right || top > bottom){
                break;
            }

            //Right->Left
            for(int i=right;i>=left;i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;

            //top->Bottom
            for(int i=bottom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
//Time- O(m.n)
//Space- O(1)
