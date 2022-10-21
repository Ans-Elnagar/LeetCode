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
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        stack.push(root);
        while(root.left != null){
            root = root.left;
            stack.push(root);
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        int temp = node.val;
        if(node.right != null){
            stack.push(node.right);
            node = node.right;
            while(node.left != null){
                node = node.left;
                stack.push(node);
            }
        }
        return temp;
    }
    
    public boolean hasNext() {
        return ! stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */