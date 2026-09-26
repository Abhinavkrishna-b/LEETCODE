class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0;
        int zeroCount = 0;
        int oneCount = 0;
        int count = 0;
        while(i<nums.length && j<nums.length){
            if(nums[j] == 0){
                zeroCount++;
            }
            else{
                oneCount++;
            }

            while(zeroCount > 1){
                if(nums[i] == 0){
                    zeroCount--;
                }
                else{
                    oneCount--;
                }
                i++;
            }
            if(zeroCount == 0){
                count = Math.max(count, (j-i+1-1));
            }
            else{
                count = Math.max(count, (j-i+1-zeroCount));
            }
            j++;
        }
        return count;
    }
}
//Time- O(n)
//Space- O(1)