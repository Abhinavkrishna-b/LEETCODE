class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //Make sure u ask the interviewer the question that if the array nums is unique or else we need to make a slight change in this code

        // HashMap<Integer,Integer> freq = new HashMap<>(); Instead of using this hashmap you can just use temp.contains() in the arraylist
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int nums[], List<Integer> temp, List<List<Integer>> result){
        if(temp.size() >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}
//Time- O(n . n!)
//Space- O(n)
//I explained the time complexity in the notes of leetcode