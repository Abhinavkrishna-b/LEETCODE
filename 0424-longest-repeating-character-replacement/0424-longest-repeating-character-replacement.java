class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,right=0;
        int maxSubStr = 0;

        int freq[] = new int[26];
        while(right<s.length()){
            freq[s.charAt(right) - 'A']++;
            int freqChar = 0; //Count of most frequent character

            for(int index=0;index<26;index++){
                freqChar = Math.max(freqChar, freq[index]);
            }

            if((right-left+1)-freqChar <= k){
                maxSubStr = Math.max(maxSubStr, (right-left+1));
                right++;
            }
            else{
                while((right-left+1)-freqChar > k){
                    freq[s.charAt(left) - 'A']--;
                    left++;
                    freqChar = 0; //Reset frequent character
                    //Still this inner loop is O(26) ~ O(1)
                    for(int index=0;index<26;index++){
                        freqChar = Math.max(freqChar, freq[index]);
                    }
                }
                right++;
            }
        }
        return maxSubStr;
    }
}
//Time- O(n)
//Space- O(1)