class Solution {
    public int longestOnes(int[] nums, int k) {
        int freq[] = new int[2];//nums contains only 0 or 1
        //In 0th index store 0 count and in 1st index store 1 count
        int i=0,j=0;
        int count = 0;
        while(i<nums.length && j<nums.length){
            //As the inner while id depended on how many 0's and 1's present
            freq[nums[j]]++;

            while(freq[0] > k){
                freq[nums[i]]--;
                i++;
            }
            count=Math.max(count, (j-i+1));
            j++;
        }
        return count;
    }
}
//Time- O(n)
//Space- O(1)