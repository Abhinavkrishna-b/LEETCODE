class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>(), result);
        //Note we use start here to avoid duplicate combinations (we can start from start+1 if start is included)
        return result;
    }

    public void backtrack(int candidates[], int target, int start, int sum, List<Integer> temp, List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<>(temp)); //But temp is a mutable ArrayList, and you continue modifying the same temp during backtracking.
            return;
        }
        if(sum > target){
            return;
        }
        //Do not start from 0 index it result in duplicate combinations
        //So start from the index excluding the prev indexes i.e the variable start
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates, target, i, sum, temp, result);
            sum-=candidates[i];
            temp.remove(temp.size()-1);
        }
    }
}
//Time- O(n^t)
//Space- O(n)