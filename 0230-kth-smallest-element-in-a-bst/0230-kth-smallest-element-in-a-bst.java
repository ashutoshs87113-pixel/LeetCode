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
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;
        int count = 0;

        while (temp != null || st.size() > 0) {

            while (temp != null) {
                st.push(temp);
                temp = temp.left;
            }

            TreeNode ans = st.pop();
            count++;

            if (count == k) {
                return ans.val;
            }

            temp = ans.right;
        }

        return -1;
    }
}