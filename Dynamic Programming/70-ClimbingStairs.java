/*

Idea = DP array. the number of ways to get to step k is just # of ways to get to k-1 + k-2

 n = 3
dp = [1, 1, 2, *3*]

      _1+2| <-
    _2| <-
  _1| <-
_1|
  */  
class Solution {
    public int climbStairs(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        
        for(int i = 2; i <= n; i++){
            nums[i] = nums[i-1] + nums[i-2];
        }
        
        return nums[n];
    }
}
