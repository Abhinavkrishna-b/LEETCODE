class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int count = 0;

        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--; 
                count++;
            } else {
                i++; 
            }
        }

        return nums.length - count;
    }
}
