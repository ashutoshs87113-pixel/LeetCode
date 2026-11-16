class Solution {

    public boolean isPossible(int[] nums, int k, int mid){

        int count = 1;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] <= mid){
                sum+=nums[i];
            }else{
                count++;
                sum = nums[i];
            }
        }
        if(count <= k) return true;
        else  return false;
    }
    public int splitArray(int[] nums, int k) {
        
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > lo) lo = nums[i];
            hi+=nums[i];
        }

        while(lo <= hi){

            int mid = lo+(hi - lo)/2;

            if(isPossible(nums,k,mid)){
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return ans;
    }
}