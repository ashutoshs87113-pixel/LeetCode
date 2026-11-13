class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int lo = 1;
        int hi = 0;
        for(int num : piles){
            hi = Math.max(hi, num);
        }

        int ans = -1;
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;

            if(sum(piles,mid) <= h){
                ans = mid;
                hi = mid - 1;
            }else{
            lo = mid+1;
            }
        }
        return ans;
    }

    public long sum(int[] nums, int mid){
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            long ans = (nums[i] + mid - 1) / mid;
            sum+=ans;
        }
        return sum;
    }
}