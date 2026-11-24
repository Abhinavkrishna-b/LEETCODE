//This is difficult so atleast solve once and mainly understand why temp.contains() is used
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //Make sure u ask the interviewer the question that if the array nums is unique or else we need to make a slight change in this code

        // HashMap<Integer,Integer> freq = new HashMap<>(); Instead of using this hashmap you can just use temp.contains() in the arraylist
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    //Actually the start parameter itself not needed
    public void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> result){
        if(temp.size() >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        //Here the i=0 because we need all the elements rearranged so we should not omit anything.
        //i=start and sending i+1 prevents previous element from using (prev cannot be used)
        for(int i=0;i<nums.length;i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            backtrack(i, nums, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}
//Time- O(n . n!)
//Space- O(n)
//I explained the time complexity in the notes of leetcode