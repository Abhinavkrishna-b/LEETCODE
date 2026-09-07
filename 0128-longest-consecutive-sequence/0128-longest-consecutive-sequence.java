class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        
        int longest = 0;
        //Important see in the below loop we are iterating the hs set not the array 
        //hs is iterated to avoid duplicate, orelse we get a TLE
        for(int num : hs){ 
            if(!hs.contains(num-1)){
                //so if a number not having its prev value mean it is the starting of that sequence
                int current = num;
                int length = 1;
                while(hs.contains(current + 1)){
                    current++;
                    length++;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
//Time- O(n)
//Space- O(n)