class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;

        int[] dp = new int[n];
        int maxLen = 0;

        Arrays.fill(dp,1);

        for(int i = 0; i < n; i++){

            int max = 0; 

            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i]+= max;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}