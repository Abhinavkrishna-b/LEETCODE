//2^31 - 1 = 2147483647 = two billion one hundred forty-seven million four hundred eighty-three thousand six hundred forty-seven = Integer.MAX_VALUE
class Solution {
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }

        String[] ones = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

        String[] tens = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

        StringBuilder result = new StringBuilder();
        //One billion = 100 crores
        if(num >= 1000000000){
            if(result.length() > 0){
                result.append(" ");
            }
            int b = num/1000000000;
            if(b <= 19){
                result.append(ones[b]);
            }
            else{
                result.append(numberToWords(b));
            }
            result.append(" Billion");
        }

        num%=1000000000;
        //One million = 10 lakhs
        if(num >= 1000000){
            if(result.length() > 0){
                result.append(" ");
            }
            int m = num/1000000;
            if(m <= 19){
                result.append(ones[m]);
            }
            else{
                result.append(numberToWords(m));
            }
            result.append(" Million");
        }

        num%=1000000;
        //One thousand = 1000
        if(num >= 1000){
            if(result.length() > 0){
                result.append(" ");
            }
            int t = num/1000;
            if(t <= 19){
                result.append(ones[t]);
            }
            else{
                result.append(numberToWords(t));
            }
            result.append(" Thousand");
        }

        num%=1000;
        //One hundred = 100
        if(num >= 100){
            if(result.length() > 0){
                result.append(" ");
            }
            int h = num/100;
            if(h <= 19){
                result.append(ones[h]);
            }
            else{
                result.append(numberToWords(h));
            }
            result.append(" Hundred");
        }

        num%=100;
        if(num > 19){
            if(result.length() > 0){
                result.append(" ");
            }
            int t = num/10;
            result.append(tens[t-2]);
            num%=10;//If num = 10;
        }

        //I take one's digit upto 19 because there is not onety like twenty
        if(num <= 19 && num >=1){
            if(result.length() > 0){
                result.append(" ");
            }
            result.append(ones[num]);
        }

        return result.toString().trim();
    }
}
// Time- O(1) - Constant Time as the int size is fixed and the recursions atmax solved in one recursion call
//Space- O(1) - Constant space as we only use O(20) ones and O(8) tens ~ O(1)
//And here there is only a small callback stack is used
//So the space is also O(1)
