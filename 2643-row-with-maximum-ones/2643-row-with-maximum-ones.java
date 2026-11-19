class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[2];
        int maxCount = 0;
        for(int i = 0; i < m; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1) count++;
            }
            if(count > maxCount){
                maxCount = count;
                ans[0] = i;
                ans[1] = maxCount;
            }
            
            
        }
        return ans;
    }
}