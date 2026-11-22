class Solution {
    public boolean checkString(String s) {
        int foundB = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'b'){
                foundB = 1;
            }
            if(ch == 'a' && foundB == 1){
                return false;
            }
        }
        return true;
    }
}
//Time- O(n)
//Space- O(1)