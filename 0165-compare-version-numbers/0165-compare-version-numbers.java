class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = 0;
        int n2 = 0;
        int i = 0, j = 0;
        while(i<version1.length() || j<version2.length()){ //Here check for || because the inner loops checks the bounds of both versions in seperate loops Edge case : 1.0.1 and 1
            while(i<version1.length() && version1.charAt(i) != '.'){
                n1 = n1*10+(version1.charAt(i)-'0');
                i++;
            }
            while(j<version2.length() && version2.charAt(j) != '.'){
                n2=n2*10+(version2.charAt(j)-'0');
                j++;
            }
            if(n1 < n2) return -1;
            if(n1 > n2) return 1;
            n1=n2=0;
            i++;
            j++;
        }
        return 0;
    }
}
//Time- O(n+m)
//Space- O(1)