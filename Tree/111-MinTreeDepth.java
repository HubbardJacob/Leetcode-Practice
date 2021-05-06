
// BFS
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList();
        int minD = 0;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            minD += 1;
            for(int i = 0; i < size; i++){
                root = queue.remove();
                if(root.left == null && root.right == null){
                    return minD;
                }
                
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
            
        }
        
        return minD;
    }
}