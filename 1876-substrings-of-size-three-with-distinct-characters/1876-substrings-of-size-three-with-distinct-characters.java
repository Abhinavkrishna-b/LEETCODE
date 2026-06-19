class Solution {
    public int countGoodSubstrings(String s) {
        // We Had only a fixed sliding window of 3
        //So it is easy to just trace that by i,i+1, i+2 to check if the window is unique
        //Or else you can also use a hashset as its space complexity is O(3) ~ O(1)

        int i=0;
        int count = 0;
        for(i=0;i<s.length()-2;i++){
            // a != b && a != c && b != c
            if(s.charAt(i) != s.charAt(i+1) && s.charAt(i) != s.charAt(i+2) && s.charAt(i+1) != s.charAt(i+2)){
                count++;
            }
        }
        return count;
    }
}
//Time- O(n)
//Space- O(1)