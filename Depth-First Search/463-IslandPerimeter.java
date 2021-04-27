class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j, rows, cols); 
                }
                
            }
        }
        
        return 0;
        
    }
    
    private int dfs(int[][] grid, int i, int j, int rows, int cols){
        
        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0){
            return 1;
        }
        else if(grid[i][j] == 2){
            return 0;
        }
        
        grid[i][j] = 2;
        int perimCount = dfs(grid, i, j+1, rows, cols);
        perimCount += dfs(grid, i-1, j, rows, cols);
        perimCount += dfs(grid, i, j-1, rows, cols);
        perimCount += dfs(grid, i+1, j, rows, cols);
        
        return perimCount;
    }
}
