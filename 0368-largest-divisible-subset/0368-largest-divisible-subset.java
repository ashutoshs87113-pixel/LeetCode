class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            prev[i] = i;
        }

        int maxLen = 1;
        int lastIdx = 0;

        for (int i = n - 2; i >= 0; i--) {

            for (int j = i + 1; j < n; j++) {

                if (nums[j] % nums[i] == 0) {

                    if (dp[i] < 1 + dp[j]) {
                        dp[i] = 1 + dp[j];
                        prev[i] = j;
                    }
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (prev[lastIdx] != lastIdx) {
            ans.add(nums[lastIdx]);
            lastIdx = prev[lastIdx];
        }

        ans.add(nums[lastIdx]);

        return ans;
    }
}