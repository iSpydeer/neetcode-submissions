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
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int levelLength = q.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = q.poll();
                levelList.add(curr.val);
                if (curr.left != null) {q.add(curr.left);}
                if (curr.right != null) {q.add(curr.right);}
            }
            list.add(levelList);
        }

        return list;
    }
}
