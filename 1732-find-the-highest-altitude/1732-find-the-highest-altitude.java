class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int sum = 0;
        for(int i : gain){
            sum+= i;
            highestAltitude = Math.max(highestAltitude,sum);
        }
        return highestAltitude;
    }
}
//Time- O(n)
//Space- O(1)