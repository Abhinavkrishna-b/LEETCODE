class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int nums[], int start, List<Integer> temp, List<List<Integer>> result){
        if(start >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        //The left decision tree
        temp.add(nums[start]);
        backtrack(nums, start+1, temp, result);

        //The right decision tree
        temp.remove(temp.size()-1);
        backtrack(nums, start+1, temp, result);
    }
}
//Time- O(n . 2^n)
//Space- O(n)
