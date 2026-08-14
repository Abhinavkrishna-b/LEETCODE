class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = 0;
        int curLen = 0;
        int i=0,j=0;
        int freq[] = new int[26];

        while(i<s.length() && j<s.length()){
            char ch = s.charAt(j);

            while(freq[ch-'a'] >= 2){
                freq[s.charAt(i)-'a']--;
                i++;
            }

            freq[ch-'a']++;
            curLen = j-i+1;
            maxLen = Math.max(curLen, maxLen);
            j++;
        }
        return maxLen;
    }
}
//Time- O(n)
//Space- O(26) ~ O(1)