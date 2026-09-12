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
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        dfs(root, k, stack);
        return stack.pop();
    }

    private void dfs(TreeNode root, int k, ArrayDeque<Integer> stack) {
        if (root == null) {
            return;
        }

        dfs(root.left, k, stack);
        if (stack.size() < k) {
            stack.push(root.val);
        } else {
            return;
        }

        dfs(root.right, k, stack);
    }
}
