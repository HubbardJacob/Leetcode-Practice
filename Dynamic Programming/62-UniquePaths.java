
/*
So much easier than it looks.............

row 0 and column 0 only have 1 way. 
Everywhere else is just above + left 
[[1,      1,      1],
 [1,      2,      3],
 [1,      3,      6]]
 
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0 || i == 0){
                    paths[i][j] = 1;
                }
                else{
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }
        
        return paths[m-1][n-1];
    }
}
