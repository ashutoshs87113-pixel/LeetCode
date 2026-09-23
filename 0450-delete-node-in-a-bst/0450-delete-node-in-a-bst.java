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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return null;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            //Case 1 for leaf node

            if(root.right == null && root.left == null)  return null;
            
            //Case 2 for 1 child Node
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            //Case 3 for 2 child Node;

            TreeNode pred = root.left;
            while(pred.right != null) pred = pred.right;
            root.left = deleteNode(root.left, pred.val);
            pred.right = root.right;
            pred.left = root.left;
            return pred;
        }

        return root;
    }
}