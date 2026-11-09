class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length;
        int sum = 0;
        int count = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            int rem = sum - k;
            if(map.containsKey(rem)){
                count+= map.get(rem);
            }
             map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}