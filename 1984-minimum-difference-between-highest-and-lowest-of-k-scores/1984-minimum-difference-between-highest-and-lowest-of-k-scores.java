class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j= i+k-1;
        int minDiff = Integer.MAX_VALUE;
        while(i<nums.length && j<nums.length){
            int curDiff = nums[j]-nums[i];
            minDiff = Math.min(curDiff, minDiff);
            i++;
            j++; //j is already k position ahead of i so do not do j+=k-1
        }
        return minDiff;
    }
}
// You can either do i=0,j=i+k-1 and i++,j=i+k-1 OR i=0,j=k-1 and i++,j++