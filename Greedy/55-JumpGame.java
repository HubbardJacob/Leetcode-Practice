
/*

Start goal at end, each time we can get there, move goal closer to beginning. should be 0 if we can get there.
   g     
[0,2,1,1,4]


goal = 1  -> cant get there no matter what. first pos is 0

*/

class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length -1;
        
        
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
        }
        
        return goal == 0 ? true : false;
    }
}
