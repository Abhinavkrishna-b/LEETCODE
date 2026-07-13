class Solution {
    public int rob(int[] nums) {
        //Iterative DP - Bottom Up
        int prev1=0,prev2=0;
        for(int num : nums){
            int t = prev1;
            prev1=Math.max(num+prev2, prev1);
            prev2=t;
        }
        return prev1;
    }
}
//Time- O(n)
//Space- O(1)
