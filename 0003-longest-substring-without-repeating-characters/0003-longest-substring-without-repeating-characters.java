class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Sliding window Approcah (Dynamic window)
        if(s.length() == 0) return 0;
        int i=0,j=0;
        int longestSubStr = 0;
        HashSet<Character> subString = new HashSet<>();
        
        while(i<s.length() && j<s.length()){
            while(subString.contains(s.charAt(j))){
                subString.remove(s.charAt(i));
                i++;
            }

            subString.add(s.charAt(j));
            longestSubStr = Math.max(longestSubStr, (j-i)+1);
            j++;

        }
        return longestSubStr;

    }
}
//Time- O(n)
//Space- O(n)