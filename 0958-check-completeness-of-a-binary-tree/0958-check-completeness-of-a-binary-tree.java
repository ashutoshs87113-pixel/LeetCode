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
    static int s;
    public boolean isCompleteTree(TreeNode root) {
        s = size(root);
        return isCBT(root, 1) && isHeap(root);
    }

    private boolean isHeap(TreeNode root) {

        if (root == null) return true;

        if(root.left != null && root.val > root.left.val) return false;
        if(root.right != null && root.val > root.right.val ) return false;
        return isHeap(root.left) && isHeap(root.right);
    }

    public int size(TreeNode root) {
        if (root == null) return 0;
        return 1+size(root.left) + size(root.right);
    }
    private boolean isCBT(TreeNode root, int i) {
        if (root == null) return true;
        if(i > s) return false;
        return isCBT(root.left, i*2) && isCBT(root.right, i*2+1);
    }
}