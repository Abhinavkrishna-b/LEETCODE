class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        while(sb.length() > k){
            int i=0;
            String str = sb.toString();
            StringBuilder New = new StringBuilder();
            while(i<str.length()){
                int sum = 0;
                for(int j=0;j<k;j++){
                    if(i+j >= str.length()){
                        break;
                    }
                    int digit = str.charAt(i+j) - '0';
                    sum+=digit;
                }
                New.append(sum);
                i+=k;
            }
            sb = New;
        }
        return sb.toString();
    }
}