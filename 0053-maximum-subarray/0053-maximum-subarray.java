class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane's Algorithm
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int num : nums){
            if(curSum < 0){
                curSum = 0;
            }
            curSum += num;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
//Time- O(n)
//Space- O(1)

