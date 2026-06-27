class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        String longPal = s.substring(0,1);
        int resLen = 1;

        for(int i=0;i<s.length();i++){
            //We just can't say that the longest palindrome is odd or even so do both
            //Odd length
            int l=i,r=i;
            while( (l>=0 && r<s.length() ) && s.charAt(l) == s.charAt(r)){
                if((r-l+1) > resLen){
                    resLen = r-l+1;
                    longPal = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            //Even length
            l=i;
            r=i+1;
            while( (l>=0 && r<s.length() ) && s.charAt(l) == s.charAt(r)){
                if((r-l+1) > resLen){
                    resLen = r-l+1;
                    longPal = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return longPal;
    }
}
//Time- O(n^2)
//Space- O(1)
