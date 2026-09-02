class Solution {
    public int maximumLengthSubstring(String s) {
        int freq[] = new int[26];
        int i=0,j=0;
        int maxLen = 0;
        while(i < s.length() && j<s.length()){
            while(freq[s.charAt(j) - 'a'] >= 2){
                freq[s.charAt(i) - 'a']--;
                i++;
            }
            freq[s.charAt(j) - 'a']++;
            maxLen = Math.max((j-i+1),maxLen);
            j++;
        }
        return maxLen;
    }
}