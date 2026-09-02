class Solution {
    public boolean uniformArray(int[] nums1) {
        int oc = 0;
        int ec = 0;
        for(int num : nums1){
            if(num%2 == 0){
                ec++;
            }
            else{
                oc++;
            }
        }
        if(oc == nums1.length || ec == nums1.length){
            return true;
        }
        if(oc >= 1){
            return true;
        }
        return false;
    }
}
//Time- O(n)
//Space- O(1)