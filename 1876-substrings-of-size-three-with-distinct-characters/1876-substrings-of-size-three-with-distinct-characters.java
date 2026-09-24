class Solution {
    public int countGoodSubstrings(String s) {
        int i=0, j=0;
        int count = 0;
        HashSet<Character> window = new HashSet<>();
        while(i<s.length() && j<s.length()){
            while(window.contains(s.charAt(j))){
                window.remove(s.charAt(i));
                i++;
            }
            window.add(s.charAt(j));
            if(window.size() == 3){
                count++;
                //Important After finding the valid window you need to remove the first element
                window.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return count;
    }
}
//Time- O(n)
//Space- O(1)
