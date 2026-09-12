class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }
    
    public void backtrack(int candidates[], int target, int sum, int start, List<Integer> temp, List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates, target, sum, i+1, temp, result);
            sum-=candidates[i];
            temp.remove(temp.size()-1);
        }
    }
}
//Time- O(2^n)
//Space- O(n)