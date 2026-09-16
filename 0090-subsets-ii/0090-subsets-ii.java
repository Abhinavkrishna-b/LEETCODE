class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int nums[], int start, List<Integer> temp, List<List<Integer>> result){
        if(start >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        //Include nums[i]
        temp.add(nums[start]);
        backtrack(nums, start+1, temp, result);

        temp.remove(temp.size()-1);

        //Exclude the nums[i] 
        //But if it contain duplicate like 2,2,2 then nums[i] = 1st 2 then we need to skip until the next non duplicate element
        while(start+1 < nums.length && nums[start] == nums[start+1]){
            start++;
        }
        //Made sure that we do not iterate the duplicate element another time
        backtrack(nums, start+1, temp, result);
    }
}
//Time- O(nlogn + n . 2^n)
//Space- O(n)