class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int rows = image.length;
        int cols = image[0].length;
        dfs(image, sr, sc, newColor, rows, cols, image[sr][sc]);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int newColor, int rows, int cols, int origColor){
        if(i < 0 || i >= rows || j < 0 || j >= cols || image[i][j] != origColor || image[i][j] == newColor){
            return;
        }
        
        image[i][j] = newColor;
        dfs(image, i+1, j, newColor, rows, cols, origColor);
        dfs(image, i, j+1, newColor, rows, cols, origColor);
        dfs(image, i-1, j, newColor, rows, cols, origColor);
        dfs(image, i, j-1, newColor, rows, cols, origColor);
    }
}
