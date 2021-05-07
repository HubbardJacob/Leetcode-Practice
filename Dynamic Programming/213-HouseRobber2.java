/*
[1, 2, 3, 1]
[1, 2, 4, 5]
Same as house robber 1. but try without front and without back <- select max
*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] withoutFront = new int[n-1];
        int[] withoutBack = new int[n-1];
        for(int i = 1; i < n; i++){
            withoutFront[i-1] = nums[i];
        }
        for(int i = 0; i < n-1; i++){
            withoutBack[i] = nums[i];
        }
        return Math.max(robCheck(withoutFront,n-1), robCheck(withoutBack,n-1));
        
    }
    
    private int robCheck(int[] nums, int n){
        
        int dp[] = new int[n];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        
        return dp[n-1];
    }
}



