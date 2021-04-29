/*

[[1,2,3],
 [4,5,6],  
 [7,8,9]]
    |
Transpose
    |
[[1,4,7], --- matrix[0][3] = matrix[3][0]
 [2,5,6],  -- matrix[1][2] = matrix[2][1]
 [3,8,9]]

Swap ends
[[7,4,1],    ---- matrix[i][j] = matrix[i][n-1-j];
 [8,5,2],
 [9,6,3]]
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){ // N/2 because we have two pointers coming inward.
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        
    }
}