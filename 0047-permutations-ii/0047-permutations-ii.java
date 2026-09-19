class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //Watch neetcode for better understand of this problem and solution
       HashMap<Integer,Integer> freq = new HashMap<>();
       for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
       }
       List<List<Integer>> result = new ArrayList<>();
       backtrack(nums, freq, new ArrayList<>(), result);
       return result;
    }

    public void backtrack(int nums[], HashMap<Integer,Integer> freq, List<Integer> temp, List<List<Integer>> result){
        if(temp.size() >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int num : freq.keySet()){
            if(freq.get(num) == 0){
                continue;
            }
            temp.add(num);
            freq.put(num, freq.get(num)-1);
            backtrack(nums, freq, temp, result);
            temp.remove(temp.size()-1);
            freq.put(num, freq.get(num)+1);
        }
    }
}
//Time - O(n . n!) see the complexity analysis in leetcode notes
//Space- O(n)