/*

idea = 
1.) if you find a min lower than current min, replace min
2.) if current is not less than min, sell, track max profit.

Local min, local max

min = 1
max_profit = 6
[7,1,5,3,6,4]
*/
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max_profit = 0;
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else{
                int curr_profit = prices[i] - min;
                
                if(curr_profit > max_profit){
                    max_profit = curr_profit;
                }
            }
        }
        
        return max_profit;
    }
}
