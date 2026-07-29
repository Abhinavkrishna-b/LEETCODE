//Imp =>  Also, ensure no index appears more than once amongst the p pairs.
// i.e Once an index is used in any pair, it cannot appear in any other pair

class Solution {
    boolean is_valid(int[] nums,int p,int m){
        int i=0,count=0;
        while(i<nums.length-1){
            if(Math.abs(nums[i]-nums[i+1]) <= m){
                count++;
                i+=2;//Once an index is used in any pair, it cannot appear in any other pair
            }
            else{
                i+=1;
            }
            if(count >= p){
                return true;
            }
        }
        return false;
    }
    
    public int minimizeMax(int[] nums, int p) {
        //Here the result may range from 0 to max(nums)
        if(p == 0)  return 0;
        Arrays.sort(nums);
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }

        int l=0,r=max;
        int result=0;
        int m=0;
        while(l<=r){
            m=l+(r-l)/2;
            if(is_valid(nums,p,m)){
                result = m;
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return result;
    }
}
//Time- O(n . log m)
//Space- O(1)