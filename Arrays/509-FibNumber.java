

/*

n = 3
3rd fib number

idea = fill in first 2 values, then we can just take the prev + prev's prev.

fibNum:    0   1   2   3 
dp Array: [0,  1,  1,  2]
                 +   =
*/
class Solution {

    public static void main(String[] args){
        System.out.println(fib(3));
    }

    public static int fib(int n) {
        if(n == 0){
            return 0;
        }
        int[] nums = new int[n+1]; // Dp array
        nums[0] = 0;
        nums[1] = 1;
        
        for(int i = 2; i <= n; i++){
            nums[i] = nums[i-1] + nums[i-2];
        }
        
        return nums[n];
    }
}


