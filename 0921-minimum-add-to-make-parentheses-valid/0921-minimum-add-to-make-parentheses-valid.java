class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> parentheses = new Stack<>();
        int insertCount = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                parentheses.push(ch);
            }
            else if(ch == ')' && parentheses.isEmpty() || parentheses.pop() != '('){
                insertCount++;
            }
        }
        //If the input is ()((( then the stack has three ( unbalanced
        while(!parentheses.isEmpty()){
            insertCount++;
            parentheses.pop();
        }
        return insertCount;
    }
}
//Time- O(n)+O(m) ~ O(n)
//Space- O(n)
