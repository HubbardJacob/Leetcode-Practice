/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        while(!queue.isEmpty() && root != null){
            int size = queue.size();
            List<Integer> currentLayer = new ArrayList();
            
            for(int i = 0; i < size; i++){
                root = queue.poll();
                currentLayer.add(root.val);
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
            if(currentLayer.size() != 0){
                result.add(currentLayer);
            }
            
        
        }
        
        return result;
    }
}
