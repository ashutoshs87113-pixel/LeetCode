class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int lo = 1;
        int hi = 0;
        for(int num : nums){
            hi = Math.max(hi, num);
        }

       int ans = -1;

        while(lo <= hi){
            int mid = lo+(hi - lo)/2;

            if(sum(nums,mid) <= threshold){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid + 1;
            }
        }
        return ans;
    }
    int sum(int[] nums, int mid){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            int ans = (nums[i] + mid - 1) / mid;
            sum+=ans;
        }
        return sum;
    }
}