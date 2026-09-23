class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        //Here the condition is numRows - 1 because you already added [1]
        for(int i=0;i<numRows-1;i++){

            //Getting the last row values from result
            List<Integer> prev = result.get(result.size()-1);
            
            //A new temp list with the first and last added extra zero
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            //copy the prev val in the middle of zeros
            for(int j=0;j<prev.size();j++){
                temp.add(prev.get(j));
            }
            temp.add(0);

            //Here put the running sum of the temp into list
            List<Integer> curRow = new ArrayList<>();
            for(int k=0;k<temp.size()-1;k++){
                curRow.add(temp.get(k) + temp.get(k+1));
            }
            result.add(curRow);
        }
        return result;
    }
}
//Time- O(n^2)
//Space- O(n)