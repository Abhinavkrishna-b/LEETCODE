class Solution {
    public int fib(int n) {
        //Brute force solution with no DP
        //This solution contains overlapping subproblems
        if(n == 0)  return 0;
        if(n == 1 || n == 2)    return 1;
        return fib(n-1)+fib(n-2);
    }
}
//Time- O(2^n)
//Space- O(1)