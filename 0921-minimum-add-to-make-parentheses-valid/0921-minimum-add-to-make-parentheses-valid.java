class Solution {
    public int minAddToMakeValid(String s) {
        //You can view the leetcode editorial solution so see that to better undertanding
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