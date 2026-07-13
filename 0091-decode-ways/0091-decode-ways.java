class Solution {
    //Instead of this numDecodings("11106") we can just pass the starting index of that substring
    public int numDecodings(String s) {
        //Top Down DP
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(0,s,dp);
    }

    public int solve(int i,String s, int dp[]){
        //Base Case 1: If the string is empty, we successfully decoded the whole thing
        //This counts as 1 valid decoding path
        if(i == s.length())  return 1;

        if(dp[i] != -1)    return dp[i];

        //Base Case 2: A leading zero is invalid. No letters map to "0", "01", etc
        //This path is a dead end
        if(s.charAt(i) == '0')     return 0;

        int countWays = 0;
        //CHOICE 1: Take just the first character
        //Since s[0] is not '0', it's a valid single digit (1-9)
        //Recurse on the remaining substring considering single digits (1-9)
        //Recurse for single digit after 1st single digit
        countWays = solve(i+1,s,dp);

        if(i + 1 < s.length()){
            int two_digit = Integer.parseInt(s.substring(i, i+2));
            if(two_digit >=10 && two_digit <= 26){
                //Recurse on the substring after the first two characters
                countWays += solve(i+2,s,dp);
            }
        }
        dp[i] = countWays;
        return dp[i];
        
    }
}
//Time- O(2^n)
//Space- O(n) - callback stack and dp array