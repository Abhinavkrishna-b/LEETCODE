class Solution {
    public String decodeString(String s) {
        //Using 2 stacks
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int digit = 0;
        String curString = "";
        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                digit = digit*10 + (ch-'0');
            }
            else if(ch >= 'a' && ch <= 'z'){
                curString+=ch;
            }
            else if(ch == '['){
                countStack.push(digit);
                stringStack.push(curString);
                digit = 0;
                curString = "";
            }
            else{ //In case of ']'
                int k = countStack.pop();
                String t = curString;
                //Here k-1 because there is already the same substring in curstring so k-1
                for(int i=0;i<k-1;i++){
                    curString+=t;
                }
                curString = stringStack.pop() + curString;
            }
        }
        return curString;
    }
}
//Time- O(max(k) n)
//Space- O(n+m)