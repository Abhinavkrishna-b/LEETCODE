class Solution {
    public int minAddToMakeValid(String s) {
        //You can view the leetcode editorial(free only for this solution) solution so see that to better undertanding

        //We need to track 1. MinAdd minimum closed paranthesis to add ()(
        //2. no of open paranthesis that are extra eg : (() 
        //Both of this leads to invalid paranthesis so track this and return the sum of these
        int openBracket = 0;
        int minAdd = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                openBracket++;
            }
            else if(ch == ')' ){
                if(openBracket == 0){
                    minAdd++;
                }
                else{
                    openBracket--;
                }
            }
        }
        return minAdd+openBracket;
    }
}
//Time- O(n)
//Space- O(1)