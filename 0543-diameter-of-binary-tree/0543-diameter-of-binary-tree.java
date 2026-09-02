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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        level(root);
        return diameter;
    }
    public int level(TreeNode root){

        if(root == null) return 0;

        int left = level(root.left);
        int right = level(root.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left , right) ;
    }
}