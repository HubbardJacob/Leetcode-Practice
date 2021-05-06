class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        return mergeHelper(root1, root2);
    }
    
    private TreeNode mergeHelper(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return null;
        }
        
        if(root1 == null && root2 != null){
            return root2;
        }
        
        if(root1 != null && root2 == null){
            return root1;
        }
        
        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeHelper(root1.left, root2.left);
        newRoot.right = mergeHelper(root1.right, root2.right);
        
        return newRoot;
        
    }
}