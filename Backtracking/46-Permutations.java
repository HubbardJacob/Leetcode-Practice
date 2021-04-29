/*
                        [_,_,_] --- (1, 2, 3)
                       /   |   \ 
         (2, 3)  [1,_,_]  [2,_,_] [3,_,_]
                 /    \
      (3)  [1, 2, _] [1, 3, _] (2) 
             /           |
      () [1, 2, 3]     [1, 3, 2] ()     
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        
        helper(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, ArrayList<Integer> curr, int[] nums, boolean[] inCurrent){
        if (curr.size() == nums.length){
            result.add(new ArrayList(curr));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if (inCurrent[i]){
                continue;
            }
            
            // Choose
            curr.add(nums[i]);
            inCurrent[i] = true;
            
            // recurse
            helper(result, curr, nums, inCurrent);    
            
            // unchoose
            curr.remove(curr.size()-1);
            inCurrent[i] = false;
            
        }
        
    }
    
}

