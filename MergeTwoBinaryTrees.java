/**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class MergeTwoBinaryTrees {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            TreeNode merged;

            if (t1 != null && t2 != null) {
                merged = new TreeNode(t1.val + t2.val);

                // recursive call for children
                if (t1.left != null || t2.left != null) // at least one tree has left child                
                    merged.left = mergeTrees(t1.left, t2.left);
                if (t1.right != null || t2.right != null) // at least one tree has right child
                    merged.right = mergeTrees(t1.right, t2.right);

            } else if (t1 != null) {
                merged = new TreeNode(t1.val);
                
                // recursive call for t1's children
                if (t1.left != null)
                    merged.left = mergeTrees(t1.left, null);
                if (t1.right != null)
                    merged.right = mergeTrees(t1.right, null);
            } else if (t2 != null) {
                merged = new TreeNode(t2.val);
                
                // recursive call for t2's children
                if (t2.left != null)
                    merged.left = mergeTrees(null, t2.left);
                if (t2.right != null)
                    merged.right = mergeTrees(null, t2.right);
            } else
                return null;

            return merged;
        }
    }
