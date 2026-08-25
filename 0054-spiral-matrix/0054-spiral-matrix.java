class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length-1;
        int left =0, right = matrix[0].length-1;
        while(top <= bottom && left <= right){
            //Left to Right
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;

            //Top to Bottom
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;

            //Eg: the matrix has n=1 or m=1 i.e [[1,2,3]] now array out of bound will be occurs now
            if(left > right || top > bottom){
                break;
            }

            //Right to Left
            for(int i=right;i>=left;i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;

            //Bottom to Top
            for(int i=bottom;i>=top;i--){
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
//Time- O(n.m)
//Space- O(1)