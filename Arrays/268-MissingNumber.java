
/*

Idea = Just create array, increment index of number, then check if any are 0

nums = [0, 1, 2, 4]
 
 0  1  2  3  4    
[0, 0, 0, 0, 0]
*/
class Solution {


    public static void main(String[] args){
        System.out.println(missingNumber(new int[] {0, 1, 2, 3}));
    }


    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int[] counts = new int[len+1];
        
        for(int i = 0; i < len; i++){
            counts[nums[i]]++;
        }
        
        for(int i = 0; i <= len; i++){
            if(counts[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
