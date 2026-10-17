class Solution {

    public int helper(int i , int j, StringBuilder text1, StringBuilder text2, int[][] dp ){

        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) return dp[i][j] = 1+ helper(i-1, j-1, text1, text2, dp);
        else return dp[i][j] = Math.max(helper(i-1, j, text1, text2, dp), helper(i, j-1, text1, text2, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                dp[i][j] = -1;
            }
        }
        return helper(m-1, n-1, new StringBuilder(text1),new StringBuilder(text2), dp);
    }
}