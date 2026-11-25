class Solution {
    public boolean canJump(int[] nums) {
        int maxreach = 0;
        for(int i=0;i<nums.length;i++){
            if(i > maxreach)   break;
            maxreach = Math.max(maxreach, i+nums[i]);
        }
        if(maxreach >= nums.length-1){
            return true;
        }
        return false;
    }
}
//Time- O(n)
//Space- O(1)