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
        int n = preorder.length;

       return build(0, n-1, 0 , n - 1, preorder, inorder);
    }
    public TreeNode build(int prelo, int prehi, int inlo , int inhi, int[] preorder,int[] inorder){

        if(prelo > prehi) return null;
        int val = preorder[prelo];
        TreeNode root = new TreeNode(val);

        int r = 0;

        for(int i = inlo; i <= inhi; i++){
            if(inorder[i] == val){
                r = i;
                break;
            }
        }
        int cnt = r - inlo;
            root.left = build(prelo + 1, prelo + cnt, inlo , r -1 , preorder, inorder);
            root.right = build(prelo + cnt + 1, prehi, r+1 , inhi , preorder, inorder);
            return root;
    }
}