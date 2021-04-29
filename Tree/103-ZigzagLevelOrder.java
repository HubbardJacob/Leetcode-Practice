/*
// push root to stack1
// stack2 is now empty, Pop root, push left, push right to stack2
// Stack1 is now empty, push right, push left

oddStack = [15]
           [7]
     


evenStack = [] 
             []
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        
        if(root == null) return result;
        Stack<TreeNode> oddStack = new Stack<TreeNode>();
        Stack<TreeNode> evenStack = new Stack<TreeNode>();
        
        oddStack.push(root);
        
        while(!oddStack.isEmpty() || !evenStack.isEmpty()){
            List<Integer> currLayer = new ArrayList();
            
            if(oddStack.isEmpty()){
                
                while(!evenStack.isEmpty()){
                    root = evenStack.pop();
                    if(root.right != null) oddStack.push(root.right);
                    if(root.left != null) oddStack.push(root.left);
                    currLayer.add(root.val);
                }
            }
            else{
                while(!oddStack.isEmpty()){
                    root = oddStack.pop();
                    if(root.left != null) evenStack.push(root.left);
                    if(root.right != null) evenStack.push(root.right);
                    currLayer.add(root.val);
                }
            }
            result.add(currLayer);
        }
        
        return result;
    }
}





