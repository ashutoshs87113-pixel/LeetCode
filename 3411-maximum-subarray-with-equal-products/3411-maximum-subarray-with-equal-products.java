class Solution {
    public int maxLength(int[] nums) {
        
        int n = nums.length;
        int maxLen = 0;

        for(int i = 0; i < n; i++){
            long product = 1;
            long lcm = 1;
            long gcD = 0;
            for(int j = i; j < n; j++){
                product*=nums[j];
                gcD = gcd(gcD, nums[j]);
                lcm = (lcm/ gcd(lcm, nums[j]) * nums[j]);
                if(product == lcm * gcD){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public long gcd(long a, long b){

        while(b != 0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}