class Solution {
    public int[] searchRange(int[] nums, int target) {
       
       int[] ans = new int[2];
       ans[0] = firstOccurence(nums, target);
       ans[1] = lastOccurence(nums, target);

       return ans;
    }

    public int firstOccurence(int[] nums, int target){
        int hi = nums.length-1;
        int lo = 0;
        int idx = -1;

        while(lo <= hi){

            int mid = lo+(hi - lo)/2;

            if(nums[mid] > target){
                hi = mid - 1;
            }
            else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                idx = mid;
                hi = mid -1;
            }
        }
        return idx;
    }

    public int lastOccurence(int[] nums, int target){
        int hi = nums.length-1;
        int lo = 0;
        int idx = -1;

        while(lo <= hi){

            int mid = lo+(hi - lo)/2;

            if(nums[mid] > target){
                hi = mid - 1;
            }
            else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                idx = mid;
                lo = mid + 1;
            }
        }
        return idx;
    }
}