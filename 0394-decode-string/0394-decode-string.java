class Solution {
    public String decodeString(String s) {
        //Using a single Character Stack
        Stack<Character> s1 = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ']'){
                String temp = "";
                String digit = "";
                //Substring 
                while(s1.peek() != '['){
                    temp = s1.pop() + temp;
                }
                s1.pop();//Pop the '['

                //Digit
                while(!s1.isEmpty() && s1.peek() >= '0' && s1.peek() <='9'){
                    digit = s1.pop() + digit;
                }
                int count = Integer.parseInt(digit);
                //Form the Decoded string
                //Repeat the SubString digit times
                String str = temp.toString();
                StringBuilder decoded = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    decoded.append(str);
                }
                for (char c : decoded.toString().toCharArray()) {
                    s1.push(c);
                }
            }
            else{
                s1.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!s1.isEmpty()){
            result.append(s1.pop());
        }
        int i=0,j=result.length()-1;
        while(i<=j){
            char temp = result.charAt(i);
            result.setCharAt(i, result.charAt(j));
            result.setCharAt(j, temp);
            i++;
            j--;
        }
        return result.toString();
    }
}
//Time- O(n+m)
//Space- O(m)
//n = length of the encoded input string
//m = length of the decoded output string