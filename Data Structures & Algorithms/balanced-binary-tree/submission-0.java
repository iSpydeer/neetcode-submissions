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
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced();
    }

    private DfsResult dfs(TreeNode root) {
        if (root == null) {
            return new DfsResult(true, 0);
        }

        DfsResult left = dfs(root.left);
        DfsResult right = dfs(root.right);

        boolean balanced = (left.isBalanced() && right.isBalanced()) &&
        Math.abs(left.height() - right.height()) <= 1;

        int height = 1 + Math.max(left.height(), right.height());
        return new DfsResult(balanced, height);
    }

    private record DfsResult(boolean isBalanced, int height) {};
}
