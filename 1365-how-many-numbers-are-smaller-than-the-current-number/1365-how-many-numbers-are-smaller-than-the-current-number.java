class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //If it is a sorted array our job will be easy but still we need to return the result in the crt order

        //consider a sorted array [1,2,2,3] => answer will be like its index 0,1,1,3 but be carefull it might have duplicates

        //St-1: So first create an empty arr with size max(nums)+1 or just keep the max length as 101 (constraint)=> initially the values be 0
        //St-2: Then update the arr with the count of elements 
        //Eg:[1,2,2,3,7] => [0,0,0,0,0,0,0,0]  use the idx of nums like res[nums[i]]++; => [0,1,2,1,0,0,0,4]
        //St-3 sum these in the new arr => [0,0,1,3,4,4,4,4] => then in place modification in the original arr and return 

        int result[] = new int[101]; //Here they specified 100 as the constraint so 100+1 is the size
        for(int i=0;i<nums.length;i++){
            result[nums[i]]++;
        }
        
        int sum=0,t=0;
        for(int i=0;i<result.length;i++){
            t=result[i];
            result[i] = sum;
            sum+=t;
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = result[nums[i]];
        }

        return nums;
    }
}
//Time- O(n)
//Space- O(101) ~ O(1) If constraint not given then O(max)
