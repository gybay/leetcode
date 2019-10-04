/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // gather the ancestors of both nodes into 2 different stacks
        Stack<TreeNode> stack_p = gatherAncestors(root, p);
        Stack<TreeNode> stack_q = gatherAncestors(root, q);
        
        // equalize the levels
        while( stack_p.size() > stack_q.size() )
            stack_p.pop();
        while( stack_q.size() > stack_p.size() )
            stack_q.pop();
        
        // compare stacks and find the LCA
        TreeNode ancestor = null;
        while( !stack_p.isEmpty() && !stack_q.isEmpty() ){
            if(stack_p.peek() == stack_q.peek()){
                ancestor = stack_p.peek();
                break;
            }
            stack_p.pop();
            stack_q.pop();
        }
        
        return ancestor;
    }
    
    /**
    * Gathers given descendandt's ancestors into a stack
    */
    private Stack<TreeNode> gatherAncestors(TreeNode root, TreeNode desc){
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode temp = root;
        stack.push(temp);
        while(temp.left != null || temp.right != null){
            if( temp == desc){
                //stack.push(temp);
                break;
            }
            else if(temp.left != null && isAncestor(temp.left, desc)){
                temp = temp.left;
                stack.push(temp);
            } else {
                temp = temp.right;
                stack.push(temp);
            }
        }
        
        return stack;
    }
    
    /**
    * searches given descendandt in given root's path. 
    * if it is in there returns true
    */
    private boolean isAncestor(TreeNode root, TreeNode desc){
        if( root == desc )  return true;
        if( root.left != null && root.right != null) return isAncestor( root.left, desc) || isAncestor( root.right, desc);
        if( root.left != null ) return isAncestor( root.left, desc);
        if( root.right != null ) return isAncestor( root.right, desc);
        return false;
    }
}
