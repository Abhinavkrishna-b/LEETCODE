class Solution {
    public int pivotIndex(int[] nums) {
        int sum[] = new int[nums.length];
        //prefix sum
        for(int i=1;i<nums.length;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        int rightSum = 0;
        int smallestIdx = -1;
        for(int i=nums.length-1;i>=0;i--){
            if(sum[i] == rightSum){
                //Eg: [0,0] return index 0 but traversing right to left return 1
                smallestIdx = i;
            }
            rightSum+=nums[i];
        }
        if(smallestIdx != -1)   return smallestIdx;
        return -1;
    }
}
//Time- O(n)
//Space- O(n)