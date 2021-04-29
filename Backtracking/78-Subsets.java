/*
// At each position i have the option to include or not include.

 
 
                []
            /         \
         [1]             []
       /     \
    [1,2]     [1]
   /     \
[1,2,3]    [1,2]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        helper(result, new ArrayList<Integer>(), nums, 0);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> current, int[] nums, int start){
        
        
        result.add(new ArrayList<>(current));
        for(int i = start; i < nums.length; i++){
            current.add(nums[i]); // add one
            helper(result, current, nums, i + 1); // recurse on decision
            current.remove(current.size()-1); // remove
        }
    }
}
