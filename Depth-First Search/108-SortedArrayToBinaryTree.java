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
    public TreeNode sortedArrayToBST(int[] nums) { 
        TreeNode root = null;
        return bstHelper(root, nums, 0, nums.length - 1);
    }
    
    private TreeNode bstHelper(TreeNode root, int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        root = new TreeNode(nums[mid]);
        root.left = bstHelper(root, nums, left, mid - 1);
        root.right = bstHelper(root, nums, mid + 1, right);
        
        return root;
        
    }
}