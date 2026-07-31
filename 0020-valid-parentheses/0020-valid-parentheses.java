class Solution {
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                parentheses.push(ch);
                continue;
            }
            if(ch == ')' && !parentheses.isEmpty()){
                if(parentheses.pop() == '('){
                    continue;
                }
            }
            if(ch == '}' && !parentheses.isEmpty()){
                if(parentheses.pop() == '{'){
                    continue;
                }
            }
            if(ch == ']' && !parentheses.isEmpty()){
                if(parentheses.pop() == '['){
                    continue;
                }
            }
            return false;
        }

        //Edge case for s = '['
        if(parentheses.isEmpty())   return true;
        return false;
    }
}
//Time- O(n)
//Space- O(n)