class Solution {
    public int maxVowels(String s, int k) {
        int left = 0, right = 0;
        int count = 0;
        int maxCount = 0;

        while(right < s.length() && left < s.length()){
            if(isVowel(s.charAt(right))){
                count++;
            }

            if((right-left+1) == k){
                maxCount = Math.max(count, maxCount);
                if(isVowel(s.charAt(left))){
                    count--;
                }
                left++;
            }
            right++;
        }
        return maxCount;
    }

    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}