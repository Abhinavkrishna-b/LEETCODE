class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,j=0;
        int count = 0;
        int curCount = 0;
        while(i<nums.length && j<nums.length){
            if(nums[j] == 0){
                curCount = 0;
                j++;
                i=j;
                continue;
            }
            curCount++;
            count = Math.max(curCount, count);
            j++;
        }
        return count;
    }
}
//Time- O(n)
//Space- O(1)