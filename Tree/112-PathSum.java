class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        
        return dfs(root, targetSum, 0);
    }
    
    private boolean dfs(TreeNode root, int targetSum, int currSum){
        if(root == null){
            return false;
        }
        
        if(root.left == null && root.right == null && currSum + root.val == targetSum){
            return true;
        }
        
        currSum += root.val;
        
        
        return dfs(root.left, targetSum, currSum) || dfs(root.right, targetSum, currSum);
    }
}