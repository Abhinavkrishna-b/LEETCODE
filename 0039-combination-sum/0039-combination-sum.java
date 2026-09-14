class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result =  new ArrayList<>();
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
            temp.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates, target, sum, i, temp, result);
            //Here we pass i as start to make sure we do not produce duplicates [2,2,3] and [3,2,2] 
            //And it we also not pass i+1 because the question says [1,1] and [1] is valid by changing the freq of count
            sum-=candidates[i];
            temp.remove(temp.size()-1);
        }
    }
}
//Time- O(n . n^d) that first n is for the inner loop and n^d is recursion time complexity
//Where d is the depth of the tree
//Space- O(n)