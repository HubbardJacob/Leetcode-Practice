class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            int num1 = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right){
                
                int sum = num1 + nums[left] + nums[right];
                
                if(sum == 0){
                    result.add(new ArrayList(Arrays.asList(num1, nums[left], nums[right])));
                    left++;
                                                                                                                      //C L   R
                    while(nums[left - 1] == nums[left] && left < right){ // This is a special case where maybe we have [0,0,0,0]
                        left++;
                    }
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        
        return result;
    }
}