class Solution {
    public int minMaxGame(int[] nums) {
        
        while(nums.length > 1){
            int n = nums.length /2;
            int[] arr = new int[n];

            for(int i = 0; i < n; i++){
                if(i % 2 ==0){
                    arr[i] =Math.min(nums[2*i] , nums[2 * i + 1]);
                }else{
                    arr[i] = Math.max(nums[2*i], nums[ 2 * i + 1]);
                }
            }
            nums = arr;
        }
        return nums[0];
    }
}