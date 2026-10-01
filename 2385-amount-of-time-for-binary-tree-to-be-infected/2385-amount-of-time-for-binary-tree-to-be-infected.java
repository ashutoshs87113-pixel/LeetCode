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

 class pair{
    TreeNode node;
    int time;

    pair(TreeNode node, int time ){
        this.node = node;
        this.time = time;
    }
 }
class Solution {

    static TreeNode start;
    static HashMap<TreeNode, TreeNode> parent;
    public int amountOfTime(TreeNode root, int target) {
        
        start = null;
        parent = new HashMap<>();

        dfs(root, target);
        Queue<pair> q = new LinkedList<>();
        HashSet<TreeNode> burned = new HashSet<>();

        q.add(new pair(start,0));

        burned.add(start);
        int maxTime =0;
        while(q.size() > 0){

        
            pair front = q.remove();

            TreeNode node = front.node;
            int time = front.time;
            maxTime = Math.max(maxTime, time);

            if(node.left != null && !burned.contains(node.left)){
                q.add(new pair(node.left, time+1));
                burned.add(node.left);
            }
              if(node.right != null && !burned.contains(node.right)){
                q.add(new pair(node.right, time+1));
                burned.add(node.right);
            }
            if(parent.containsKey(node) && !burned.contains(parent.get(node))){
                q.add(new pair(parent.get(node), time+1));
                burned.add(parent.get(node));
            }
        }
        return maxTime;
    }
    public static void dfs(TreeNode root, int target){
        if(root == null) return;

        if(root.val == target) start = root;
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);
        dfs(root.left, target);
        dfs(root.right, target);

    }
}