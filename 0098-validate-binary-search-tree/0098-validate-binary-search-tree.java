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

    public boolean check(TreeNode root, TreeNode left, TreeNode right){

        if(root == null){
            return true;
        }
        if(left != null && left.val >= root.val){
            return false;
        }
        if(right != null && right.val <= root.val){
            return false;
        }
        return check(root.left, left, root) && check(root.right, root,right );
    }
    public boolean isValidBST(TreeNode root) {
        

       return check(root, null, null);

    }
}