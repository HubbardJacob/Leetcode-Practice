
/*

      i
nums1 = [2,4,5,0,0,0,0,0,0]


         j
nums2 = [1,5,6,7,8,9]


   e 
[1,2,4,5,5,6,7,8,9]


1.) three pointers i (nums1), j (nums2), and endpointer
2.) if i is bigger or equal to j, put at endpointer

EXTRA CASE: if all bigger in i, j will have left over, need extra loop
*/



class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int end = m + n - 1;
        
        
        while(i >= 0 && j >= 0){
            
            if(nums1[i] >= nums2[j]){
                nums1[end--] = nums1[i--];
            }
            else{
                nums1[end--] = nums2[j--];
            }
        }
        
        while(j >= 0){
            nums1[end--] = nums2[j--];
        }
    }
}