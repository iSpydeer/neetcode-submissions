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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(
            Arrays.stream(preorder).boxed().toList(), 
            Arrays.stream(inorder).boxed().toList()
        );
    }

    private TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.getFirst());
        int mid = inorder.indexOf(preorder.getFirst());
        
        root.left = buildTree(
            preorder.subList(1, mid + 1), 
            inorder.subList(0, mid)
        );

        root.right = buildTree(
            preorder.subList(mid + 1, preorder.size()),
            inorder.subList(mid +1, inorder.size())
        );

        return root;
    }
}
