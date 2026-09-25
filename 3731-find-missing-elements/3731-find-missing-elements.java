class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        
        int n = nums.length;
        int lo = Integer.MAX_VALUE;
        int hi =  Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            set.add(nums[i]);

            hi = Math.max(nums[i], hi);
            lo = Math.min(nums[i], lo);

        }
        for(int i = lo; i < hi; i++ ){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}