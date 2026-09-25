//Both the accepted solution are same while 1st one use j-i+1 instead of window size
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i=0,j=0;
        long sum = 0;
        long curSum = 0;
        HashSet<Integer> window = new HashSet<>();
        while(i<nums.length && j<nums.length){
            //The important stuff is if duplicate value came then you need to update i and modify the nums[j] as new value in the window
            while(window.contains(nums[j])){
                window.remove(nums[i]);
                curSum-=nums[i];
                i++;
            }

            window.add(nums[j]);
            curSum+=nums[j];
            if(window.size() == k){
                sum=Math.max(sum, curSum);
                //I just forgot to shrink the window for next iteration after it reaches k
                window.remove(nums[i]);
                curSum-=nums[i];
                i++;
            }
            j++;
        }
        return sum;
    }
}
//Time- O(n)
//Space- O(k)