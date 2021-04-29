class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    islandCount++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return islandCount;
    }
    
    
    public void dfs(char[][] grid, int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || grid[i][j] == '2'){
            return;
        }
        else{
            grid[i][j] = '2';
            dfs(grid, i + 1, j, m, n);
            dfs(grid, i, j + 1, m, n);
            dfs(grid, i - 1, j, m, n);
            dfs(grid, i, j - 1, m, n);
        }
    }
}
