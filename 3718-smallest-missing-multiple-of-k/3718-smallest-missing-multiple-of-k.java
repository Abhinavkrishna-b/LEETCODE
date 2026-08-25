class Solution {
    public int missingMultiple(int[] nums, int k) {
        int i=1;
        while(true){
            int flag = 0;
            for(int j=0;j<nums.length;j++){
                if(nums[j] == i*k){
                    flag = 1;
                }
            }
            if(flag == 0){
                return i*k;
            }
            i++;
        }
    }
}
//Time- O(nm) n - len of nums m - how many times while loop runs
//Space- O(1)