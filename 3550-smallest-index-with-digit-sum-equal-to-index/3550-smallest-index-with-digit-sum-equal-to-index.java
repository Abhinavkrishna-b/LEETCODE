class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int digitSum = 0;
            int temp = nums[i];
            while(temp > 0){
                int digit = temp%10;
                digitSum += digit;
                temp/=10;
            }
            if(digitSum == i){
                //Because as we travese from i=0 to n so we are already checking from the smallest
                return i;
            }
        }
        return -1;
    }
}
//Time- O(n . d)
//Space- O(1)