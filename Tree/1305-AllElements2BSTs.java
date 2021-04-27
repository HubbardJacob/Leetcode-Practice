// Time complexity: O(nlog(n)) space: O(r1*r2) 
// We can just do in order traversal on both, adding to a list, then sort the list.

/*

    2                1
   / \             /   \
  1   4           0     3
  
  
*/
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList();
        bstHelper(root1, result);
        bstHelper(root2, result);
        
        Collections.sort(result);
        return result;
    }
    private void bstHelper(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        
        bstHelper(root.left, result);
        result.add(root.val);
        bstHelper(root.right, result);
        
    }

        
        
}

