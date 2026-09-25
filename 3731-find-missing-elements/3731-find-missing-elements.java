class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        Arrays.sort(nums);
        int n = nums.length;
        int lo = nums[0];
        int hi = nums[n-1];

        for(int i = 0; i < n; i++) set.add(nums[i]);

        for(int i = lo; i < hi; i++ ){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}