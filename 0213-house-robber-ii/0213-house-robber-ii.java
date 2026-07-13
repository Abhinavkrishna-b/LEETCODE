class Solution {
    public int rob(int[] nums) {
        //It is similiar to house robber 1
        //To solve this problem of circular houses -> find max money can be rob from 0 to len-2 and 1 to len-1. Max of these two is the answer. Use the house robber 1 to find the max of each interval

        if(nums.length == 1)    return nums[0];
        //Important Edge case - both loop fails
        int prev1 = 0;
        int prev2 = 0;
        for(int i=0;i<nums.length-1;i++){
            int t = prev1;
            prev1 = Math.max(nums[i]+prev2, prev1);
            prev2 = t;
        }
        int Rob1 = prev1;
        prev1 = prev2 = 0;
        for(int i=1;i<nums.length;i++){
            int t = prev1;
            prev1 = Math.max(nums[i]+prev2, prev1);
            prev2 = t;
        }
        int Rob2 = prev1;
        return Math.max(Rob1,Rob2);
    }
}
//Time- O(n)+O(n) ~ O(n)
//Space- O(1)