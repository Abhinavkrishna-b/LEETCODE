//Refer leetcode notes
class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        StringBuilder result = new StringBuilder();
        for(char ch : s.toCharArray()){
            //If it is a first open paranthesis then do not add it
            if(ch == '('){
                if(open > 0)    result.append(ch);
                open++;
            }

            //If it is the last close paranthesis then do not add it
            if(ch == ')'){
                open--;
                if(open > 0)    result.append(ch);
            }
        }
        return result.toString();
    }
}
//Time- O(n)
// Space- O(n)