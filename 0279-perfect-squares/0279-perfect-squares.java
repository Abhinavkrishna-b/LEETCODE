class Solution {
    public int numSquares(int n) {
        //Memoization - Top down dp

        //dp[x] = min squares needed to make x
        int dp[] = new int[n+1];
        return solve(n,dp);
    }

    public int solve(int n,int dp[]){
        if(n==0)    return 0;
        if(dp[n]!=0)   return dp[n];
        int ans=Integer.MAX_VALUE;

        for(int i=1;i*i<=n;i++){
            ans=Math.min(ans, 1+solve(n-i*i, dp));
        }

        return dp[n]=ans;
    }
}
//Time- O(n . sqrt(n))
//Space- O(n) - call back stack