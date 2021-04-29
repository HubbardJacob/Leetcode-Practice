/* 
Kdanes algo dp approach
we can go through each element and decide to continue summing, 
or restart at the current one we are looking at. pick max.
[3, 4, -10, 20]
             ^     
     
[20]  > [3 + 4 + -10 + 20] ? yes - restart

curr_sum = 20
max_sum = 20;
*/
class Solution {
    public int maxSubArray(int[] nums) {
        
        int max_sum = nums[0];
        int curr_sum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            curr_sum += nums[i];
            if(nums[i] > curr_sum){
                curr_sum = nums[i];
            }
            
            if(curr_sum > max_sum){
                max_sum = curr_sum;
            }
        }
        return max_sum;
    }
}