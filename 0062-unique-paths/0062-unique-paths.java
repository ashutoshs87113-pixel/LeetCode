class Solution {
    static int[][] dp;

    public int path(int m, int n){
        if(m == 1 || n == 1) return 1;

        if(dp[m][n] != 0) return dp[m][n];
        return dp[m][n] = path(m-1, n) + path(m, n-1);
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];

        return path(m,n);
    }
}