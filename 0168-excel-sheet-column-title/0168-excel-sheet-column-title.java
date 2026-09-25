//Refer the leetcode notes to better understanding
class Solution {
    public String convertToTitle(int columnNumber) {
        //for 28="AB" = > come from the last 28 so to find be you need to %26 but it may return 0 but A=1,B=2... start from 1 Eg given 26 then 26%26 gives 0 = A but it need to be Z so -1 => 26-1%26 = 25 => Z
        //So you do (28-1)%26 = 1=>B 28-1/26=2 (1-1)%26 => 0 = A
        //So finally reverse it

        StringBuilder sb = new StringBuilder();
        int n=columnNumber;
        while(n > 0){
            char ch = (char) ('A' + (n-1)%26); //Add a to make it as a character 0+'A' = 0+65 = 65
            sb.append(ch);
            n = (n-1)/26;
        }
        return sb.reverse().toString();
    }
}
//Time- O(n)
//Space- O(1)