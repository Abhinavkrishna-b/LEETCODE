class Solution {
    //Top-Down DP
    //Intuition - Rob or Skip the current house
    public int rob(int[] nums) {
        // [2,1,1,2] it is not necessary that you need to rob any one house that is adjacent - here to get max money you not rob 1 or 1 instead you go to 2 and 2
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }

    public int solve(int i, int nums[],int dp[]){
        if(i >= nums.length)    return 0;
        if(dp[i] != -1)    return dp[i];

        dp[i] = Math.max(nums[i]+solve(i+2,nums,dp), solve(i+1,nums,dp));
        return dp[i];
    }
}
//Time- O(n)
//Space- O(n) - callback stack and dp array