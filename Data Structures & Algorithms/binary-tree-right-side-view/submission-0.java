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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            int levelLength = q.size();
            boolean flag = false;
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = q.poll();
                if (!flag) {
                    list.add(curr.val);
                    flag = true;
                }

                if(curr.right != null) {q.add(curr.right);}
                if(curr.left != null) {q.add(curr.left);}
            }
        }
        return list;
    }
}
