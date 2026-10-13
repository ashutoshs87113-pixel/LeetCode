class Solution {
    public int rob(int[] nums) {

        int[] dp = new int[3];

        if (nums.length == 1)
            return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        
        if(nums.length == 2) return dp[1];
        for (int i = 2; i < nums.length; i++) {
            dp[2] = Math.max(nums[i] + dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}