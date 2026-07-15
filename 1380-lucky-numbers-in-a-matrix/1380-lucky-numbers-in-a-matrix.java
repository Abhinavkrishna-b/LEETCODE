class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length; 
        int rowMin[] = new int[r];
        int colMax[] = new int[c];
        int curMin = Integer.MIN_VALUE, curMax = Integer.MAX_VALUE;
        for(int i=0;i<r;i++){
            curMin = Integer.MAX_VALUE;
            for(int j=0;j<c;j++){
                curMin = Math.min(curMin, matrix[i][j]);
            }
            rowMin[i] = curMin;
        }
        
        for(int i=0;i<c;i++){
            curMax = Integer.MIN_VALUE;
            for(int j=0;j<r;j++){
                curMax = Math.max(curMax, matrix[j][i]);
            }
            colMax[i] = curMax;
        }
        ArrayList<Integer> luckyNum = new ArrayList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]){
                    luckyNum.add(rowMin[i]);
                }
            }
        }

        return luckyNum;
    }
}
//Time- O(rc)
//Space- O(r+c)