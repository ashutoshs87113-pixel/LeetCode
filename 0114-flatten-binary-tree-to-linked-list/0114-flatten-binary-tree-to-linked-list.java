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

 // morris traversal
class Solution {
    public void flatten(TreeNode root) {
        
        TreeNode c = root;

        while(c != null){
            if(c.left != null){
                TreeNode p = c.left;
                while(p.right != null) p = p.right;

                p.right = c.right;
                c.right = c.left;
                c.left = null;
                c = c.right;
            }else{
                c = c.right;
            }
        }
    }
}