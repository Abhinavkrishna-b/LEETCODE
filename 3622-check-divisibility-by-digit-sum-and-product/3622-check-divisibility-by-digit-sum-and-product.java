class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int productSum = 1;
        int temp = n;
        while(temp > 0){
            int digit = temp%10;
            digitSum += digit;
            productSum *= digit;
            temp /= 10;
        }
        //The question asks if n is divisible by digitSum+productSum
        return n%(digitSum+productSum) == 0; 
    }
}
//Time- O(n)
//Space- O(1)