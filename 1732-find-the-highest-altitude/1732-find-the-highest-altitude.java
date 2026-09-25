class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int Altitude = 0;
        for(int i=0;i<gain.length;i++){
            Altitude+=gain[i];
            highestAltitude = Math.max(Altitude, highestAltitude);
        }
        return highestAltitude;
    }
}
//Time- O(n)
//Space- O(1)