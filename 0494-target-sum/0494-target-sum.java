class Solution {
    static int abs;
    public int helper(int i, int sum, int target, int[] nums,  int[][] dp){
        if(i == nums.length) {
            if(target == sum) return 1;
            else return 0;
        }
        if(dp[i][sum+ abs] != 0) return dp[i][sum+ abs];
        int add = helper(i+1, sum + nums[i],target,  nums,dp);
        
        int remove = helper(i+1, sum - nums[i],target,  nums, dp);
         
        return  dp[i][abs+sum] = add + remove;
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        abs = 0;

        for(int i = 0; i < nums.length; i++){
            abs += nums[i];
        }

        int[][] dp = new int[nums.length][(2*abs)+1];
        return helper(0,0, target, nums , dp);
    }
}