class Solution {
    public double myPow(double x, int n) {
        if(n == 0)  return 1;
        if(x==0)    return 0;
        long N = n;
        //Important to handle this overflow
        if(n < 0){
            return 1/thePow(x,-N);//negative n is important
        }
        else{
            return thePow(x,n);
        }
    }
    public double thePow(double x,long n){
        if(n == 0)  return 1;
        if(n%2 == 0){
            double t = thePow(x,n/2);
            return t*t;
        }
        else{
            double t = thePow(x,(n-1)/2);
            return t*t*x;
        }
    }
}