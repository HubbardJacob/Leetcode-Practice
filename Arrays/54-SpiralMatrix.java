/*            L R
          [[1,2,3],
        T  [4,5,6],
        B  [7,8,9]]
    
      l           r
   t [[1,2, 3,  4],
      [5,6, 7,  8],
      [9,10,11,12]]
    b
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        List<Integer> res = new ArrayList();
        while(left < right && top < bottom){
            for(int i = left; i < right; i++){
                res.add(matrix[top][i]);
            }
            
            top++;
            
            for(int i = top; i < bottom; i++){
                res.add(matrix[i][right-1]);
            }
            
            right--;
            
            if(left >= right || top >= bottom){
                break;
            }
            for(int i = right-1; i >= left; i--){
                res.add(matrix[bottom-1][i]);
            }
            
            bottom--;
            
            for(int i = bottom-1; i >= top; i--){
                res.add(matrix[i][left]);
            }
            
            left++;
        }
        
        return res;
    }
}