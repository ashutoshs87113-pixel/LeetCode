class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        int maxCount = 0;

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(int ele: set){
            if(!set.contains(ele - 1)) {
                int x = ele;
                int count = 1;

                while(set.contains(x+1)){
                    count++;
                    x++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}