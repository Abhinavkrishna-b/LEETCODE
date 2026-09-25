//Must Refer the leetcode notes in this!

class Solution {
    public int titleToNumber(String columnTitle) {
        // understand the question the series is A-Z AA-AZ BA-BZ ...
        //The solution pattern "CBA" => 3*26+2 + 2*26*1 + 1*26+0
        
        int total = 0;
        for(char ch : columnTitle.toCharArray()){
            total = total*26 + (ch - 'A')+1;
        }
        return total;
    }
}
//Time- O(n)
//Space- O(1)
