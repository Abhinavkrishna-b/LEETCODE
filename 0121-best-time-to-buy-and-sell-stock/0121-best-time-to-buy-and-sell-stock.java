class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        int maxProfit = 0;
        for(int curVal : prices){
            if(curVal < minPrice){
                minPrice = curVal;
            }
            else{
                profit = curVal - minPrice;
            }
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
//Time- O(n)
//Space- O(1)