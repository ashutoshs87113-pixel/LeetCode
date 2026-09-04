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
    public void flatten(TreeNode root) {

        if(root == null) return;
        ArrayList<Integer> ans = dfs(root);
       

        TreeNode temp = root;
        for(int i = 1; i < ans.size(); i++){
            temp.right = new TreeNode(ans.get(i));
            temp.left = null;
            temp = temp.right;
        }
        temp.right = null;
    }

    public ArrayList<Integer> dfs(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        ans.add(root.val);
        ans.addAll(dfs(root.left));
        ans.addAll(dfs(root.right));

        return ans;
    }
}