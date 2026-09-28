class Solution {
    public int maxDepth(String s) {
        //It is guaranted that parentheses are valid
        int maxCount = 0;
        int open = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++;
            }
            if(ch == ')'){
                open--;
            }
            maxCount = Math.max(maxCount, open);
        }
        return maxCount;
    }
}
//Time- O(n)
//Space- O(1)