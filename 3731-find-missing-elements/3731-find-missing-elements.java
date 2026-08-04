class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> missing = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(nums[i], min);
            max = Math.max(nums[i],max);
        }

       int flag = 0; 
        for(int i=min+1;i<max;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                missing.add(i);
            }
            flag=0;
        }
        return missing;
    }
}
//Time- O(n)
//Space- O(1) - without considering the output list