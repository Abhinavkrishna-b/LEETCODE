class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();
        int i = 0, j = 0;
        int longest = 0;
        while(i < s.length() && j < s.length()){
            while(window.contains(s.charAt(j))){
                window.remove(s.charAt(i));
                i++;
                //Here do not decrement longest it must be only done by max()
            }
            window.add(s.charAt(j));
            longest = Math.max(longest, (j-i+1));
            j++;
        }
        return longest;
    }
}
//Time- O(n)
//Space- O(n)