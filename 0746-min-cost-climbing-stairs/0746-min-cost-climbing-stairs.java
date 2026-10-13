class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        if(cost.length == 1) return cost[0];

        int[] dp = new int[3];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < cost.length; i++){
            dp[2] = cost[i] + Math.min(dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return Math.min(dp[0], dp[1]);
    }
}