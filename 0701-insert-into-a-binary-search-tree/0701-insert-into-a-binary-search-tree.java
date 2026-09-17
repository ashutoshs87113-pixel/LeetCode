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

    public void attach(TreeNode root, int val) {

        if(root == null) return;

        if(root.val == val) return;

        if(root.val > val) {

            if(root.left == null) {
                root.left = new TreeNode(val);
                return;
            }

            attach(root.left, val);

        } else {

            if(root.right == null) {
                root.right = new TreeNode(val);
                return;
            }

            attach(root.right, val);
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null) {
            return new TreeNode(val);
        }

        attach(root, val);

        return root;
    }
}