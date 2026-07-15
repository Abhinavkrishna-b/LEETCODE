class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;
        int i=1,j=2,count=0;
        while(count < n){
            oddSum += i;
            evenSum += j;
            i+=2;
            j+=2;
            count++;
        }

        int gcd=1;
        for(i=1;i<= Math.min(oddSum,evenSum);i++){
            if(oddSum%i == 0 && evenSum%i == 0){
                gcd=i;
            }
        }
        return gcd;
    }
}
//Time- O(n^2)
//1st loop - O(n)
//2nd loop - O(min(oddSum, evenSum))
//How big can odd and even sums can be :
//If you sum the first n odd numbers, oddSum becomes exactly n^2.
//If you sum the first n even numbers, oddSum becomes exactly n(n+1) => n^2 + n.
//So O(n) + O(n^2) ~ O(n^2)
//Space- O(1)
