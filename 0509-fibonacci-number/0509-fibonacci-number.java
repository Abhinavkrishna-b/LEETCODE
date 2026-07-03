class Solution {
    public int fib(int n) {
        //DP approach - Top Down (Memoization)
        int memo[] = new int[n+1];
        return fibanocci(n,memo);
    }

    public int fibanocci(int n,int memo[]){
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        if(memo[n] != 0){
            return memo[n];
        }

        memo[n] = fibanocci(n-1, memo) + fibanocci(n-2, memo);
        return memo[n];
    }
}
//Time- O(n)
//Space- O(n)