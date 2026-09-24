class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2]; //Here i m just using this like we used to do in max = nums[0]
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int j=i+1,k=nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == target)   return sum;
                //Chacking if the current sum is closest to the target or not
                if(Math.abs(closest-target) > Math.abs(sum-target)){
                    closest = sum;
                }     
                if(sum > target)    k--;
                else    j++;
            }
        }
        return closest;
    }
}
//Time- O(n log n) + O(n^2) ~ O(n^2)
//Space- O(1)
