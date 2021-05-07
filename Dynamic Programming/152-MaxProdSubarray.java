

/*
    
             [-1, -2, -3,  4,  0, -2]
curMin        -1  -2  -6  -24  1  -2  
curMax        -1   2   6   24  1  -2
*/
class Solution {
    public int maxProduct(int[] nums) {
        int res = findMax(nums);
        int curMin = 1;
        int curMax = 1;
        for(int num: nums){
            
            if(num == 0){
                curMin = 1;
                curMax = 1;
                continue;
            }
            
            int tmp = curMax;
            curMax = Math.max(num * curMax, Math.max(num * curMin, num));
            curMin = Math.min(num * tmp, Math.min(num * curMin, num));
            
            res = Math.max(res, curMax);
        }
        
        return res;
    }
    
    private int findMax(int[] nums){
        int max = nums[0];
        for(int num: nums){
            if(num > max){
                max = num;
            }
        }
        return max;
    }
}