class Solution {
    public int maxVowels(String s, int k) {
        int i=0,j=0;
        int count = 0;
        int curCount = 0;
        while(i<s.length() && j<s.length()){
            while((j-i+1) > k){
                if(isVowel(s.charAt(i))){
                    curCount--;
                }
                i++;
            }
            if(isVowel(s.charAt(j))){
                curCount++;
            }
            if((j-i+1) == k){
                count = Math.max(count, curCount);
            }
            j++;
        }
        return count;
    }

    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}
//Time- O(n)
//Space- O(1)
