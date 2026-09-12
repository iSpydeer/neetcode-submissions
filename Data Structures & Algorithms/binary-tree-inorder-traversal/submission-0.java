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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        inorderTraversal(root, retList);
        return retList;
    }

    private void inorderTraversal(TreeNode root, List<Integer> retList) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, retList);
        retList.add(root.val);
        inorderTraversal(root.right, retList);    
    }
}