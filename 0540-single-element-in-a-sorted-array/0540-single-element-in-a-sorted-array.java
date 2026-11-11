class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int lo = 0;
        int hi = nums.length-1;

        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length - 2]) return nums[nums.length - 1];

        while(lo <= hi){
            int mid = lo+(hi-lo)/2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];

            
                int s = mid, f = mid;
                if(nums[mid - 1] == nums[mid]) s = mid - 1;
                else
                f = mid+1;

                int leftCount = s - lo;
                int rightCount = hi - f;

                if(leftCount % 2 == 0) lo = f + 1;
                else hi = s - 1;
            
        }
        return 1;
    }
}