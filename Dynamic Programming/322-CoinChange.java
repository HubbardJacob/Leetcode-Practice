
/*

 0   1  2  3  4  5  6  7  8  9  10  11
[0,  1, 1, 12, 12 ,12 ,12 ,12 ,12 ,12]

*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        
        for(int i = 1; i < dp.length; i++){
            dp[i] = amount + 1;
        }
        
        
        for(int i = 1; i < dp.length; i++){
            for(int coin : coins){
                if(i-coin >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }

            }
        }
        if(dp[amount] == amount+1){
            return -1;
        }
        return dp[amount];
    }
}



