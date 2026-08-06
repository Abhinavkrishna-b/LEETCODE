class Solution {
    public int smallestNumber(int n, int t) {
        int i=n;
        while(true){
            int prd = 1;
            int digit = i;
            while(digit > 0){
                prd*= digit%10;
                digit/=10;
            }
            if(prd%t == 0){
                return i;
            }
            i++;
        }
    }
}