// the optimize time- O(n) logic is in the leetcode notes

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i=1;i<=n/2;i++){
            if(n%i == 0){
                String temp = s.substring(0,i).repeat(n/i);
                if(temp.equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}
//Time- O(n^2)
//Space- O(1)
//As here i created a string temp without it also i can directly check that in the if() so it is O(1) space i considered