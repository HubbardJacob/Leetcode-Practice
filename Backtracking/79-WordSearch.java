class Solution {
    
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        HashSet<List<Integer>> seen = new HashSet();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (dfs(board, word, i, j, m, n, seen, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int m, int n, HashSet<List<Integer>> seen, int currPos) {
        if(currPos == word.length()){
            return true;
        }
        
        if(i < 0 || i >= m || j < 0 || j >= n 
           || board[i][j] != word.charAt(currPos) 
           || seen.contains(new ArrayList(Arrays.asList(i,j)))){
            return false;
        }
        

        seen.add(new ArrayList(Arrays.asList(i,j))); // Start path, we dont want to come back to this position
        
        boolean res =  (dfs(board, word, i+1, j, m, n, seen, currPos+1) || 
                        dfs(board, word, i, j+1, m, n, seen, currPos+1) || 
                        dfs(board, word, i-1, j, m, n, seen, currPos+1) || 
                        dfs(board, word, i, j-1, m, n, seen, currPos+1));
        
        seen.remove(new ArrayList(Arrays.asList(i,j))); // we can go back on this position again
        
        return res;
    }
}