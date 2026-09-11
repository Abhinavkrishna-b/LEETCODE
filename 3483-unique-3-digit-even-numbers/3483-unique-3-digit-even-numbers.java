class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> seen = new HashSet<>(); //To ensure no duplicate 3 digit nums are counted eg : 202 may formed twice

        //What is a 3 digit even number - last digit even and first digit non zero
        //So we are gona try for every index
        //i - hunderds digit, j - tens digit, k - ones digit
        //Then build the number and check if it is even
        for(int h=0;h<digits.length;h++){
            if(digits[h] == 0){
                continue;
            }
            for(int t=0;t<digits.length;t++){
                //You should only skip the current val of h but need the prev and after val of h
                if(t == h){
                    continue;
                }
                for(int o=0;o<digits.length;o++){
                    if(h == o || t == o){
                        continue;
                    }

                    if(digits[o]%2 != 0){
                        continue;
                    }

                    int num = digits[h]*100 + digits[t]*10 + digits[o];
                    seen.add(num);
                }
            }
        }
        return seen.size();
    }
}
//Time- O(n^3)
//Space- O(m)
//m is no of distinct 3 digit even numbers can be formed