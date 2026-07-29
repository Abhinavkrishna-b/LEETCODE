class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        //Edge case : [-100,-98,-1,2,3,4] Here answer is not the product of largest numbers
        //We need -100 * -98 * 4 = min1 * min2 * max1

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num : nums){
            //Three largest values
            if(max1 <= num){
                max3=max2;
                max2=max1;
                max1=num;
            }
            else if(max1 > num && max2 <= num){
                max3 = max2;
                max2 = num;
            }
            else if(max2 > num && max3 < num){
                max3 = num;
            }

            //two smallest values
            if(min1 >= num){
                min2=min1;
                min1=num;
            }
            else if(min1 < num && min2 > num){
                min2 = num;
            }
        }
        return Math.max( (max1*max2*max3), (min1*min2*max1));
    }
}