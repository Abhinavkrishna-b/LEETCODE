class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            //Avoid Duplicates [-3,-3,1,2,3,4]
            if(i>0 && nums[i] == nums[i-1]){ //Here i>0 to ensure i is not i=0 then nums[0] == nums[-1]
                continue;
            }

            int j=i+1,k=nums.length-1; //Here j=i+1 
            while(j < k){
                int THREE_SUM = nums[i]+nums[j]+nums[k];
                //The intuition is Two-Sum-2
                if(THREE_SUM < 0){
                    j++;
                } 
                else if(THREE_SUM > 0){
                    k--;
                }
                else{
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));

                    //Remeber the below loop is to ensure that in this second while loop that is basically 2sum II you don't need to repeat dupicate element sum
                    //Eg: the outer loop has 0 and the inner loops runs for [2,2,0,-2,-2] now it make sense you do not want to add duplicates results
                    //Also in outer loop a condition does this same see

                     //Avoid duplicates make sure you keep this inside the else part
                     //Because this j+=1 if placed outside will run every time causing some mising in when time like (j no increse and k increase) like when 2nd else part executed it is a problem.
                    j+=1;
                    while(j<k && nums[j] == nums[j-1]){
                        j++;
                    }
                }

            }
        }
        return result; 
    }
}
//Time- O(n log n) + O(n^2) ~ O(n^2)
//Space- O(1)