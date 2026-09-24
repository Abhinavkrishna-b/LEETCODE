class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j] == nums[j-1]){ //Important j > i+1
                    continue;
                }

                int k=j+1, l=nums.length-1;
                while(k<l){
                    //Here to avoid overflow it is long converted
                    long FOUR_SUM = (long) nums[i]+nums[j]+nums[k]+nums[l];
                    if(FOUR_SUM == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k+=1;
                        while(k<l && nums[k] == nums[k-1]){
                            k++;
                        }
                        continue;
                    }
                    if(FOUR_SUM > target){
                        l--;
                    }
                    else{
                        k++;
                    }
                }
            }
        }
        return result;
    }
}
//Time- O(n^3)
//Space- O(1)
