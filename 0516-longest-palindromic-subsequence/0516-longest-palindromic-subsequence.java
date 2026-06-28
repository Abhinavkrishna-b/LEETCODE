class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int dp[][] = new int[s.length()+1][rev.length()+1];

        for(int i=s.length()-1;i>=0;i--){
            for(int j=rev.length()-1;j>=0;j--){
                if(s.charAt(i) == rev.charAt(j)){
                    dp[i][j] = 1+dp[i+1][j+1];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
//Time- O(n^2)
//Space- O(^2)
//What if they need that longest palindromic subsequence itself - i have sent the code in whatsapp to you itself