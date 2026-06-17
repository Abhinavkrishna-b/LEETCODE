class Solution {
    public boolean judgeSquareSum(int c) {
        //Two Pointer
        long left = 0, right = (int) Math.sqrt(c); 
        long sum = 0;
        //Here Long because there is a possibility of overflow in case of big values for c
        //Here left starts with 0 because sometimes it might be 0+b^2 = c

        while(left <= right){
            sum = (left*left) + (right*right);
            if(sum == c){
                return true;
            }
            if(sum < c){
                left++;
            }
            else{ //Sum > c
                right--;
            }
        }
        return false;
    }
}
//Time- O(sqrt(c))
//Space- O(1)