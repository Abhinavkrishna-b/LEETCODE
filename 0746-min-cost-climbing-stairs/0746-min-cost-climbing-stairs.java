class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //Top Down approach DP 
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1); //Here i filled the array with -1 because 0 <= cost[i] <= 999 there may be 0

        return Math.min(solve(0,cost,dp), solve(1,cost,dp));
    }

    public int solve(int i, int cost[], int dp[]){
        if(i >= cost.length)    return 0;
        if(dp[i] != -1)    return dp[i];

        dp[i] = cost[i] + Math.min(solve(i+1,cost,dp), solve(i+2,cost,dp));
        return dp[i];
    }
}
//Time- O(n)
//Space- O(n)