class Solution {
    public int missingMultiple(int[] nums, int k) {
       
       
       int multiple = k;
       while(true){
        int count = 0;
       for(int i = 0; i < nums.length; i++){
        if(nums[i] == multiple){
            count++;
        }
       } 
       if(count == 0){
        return multiple;
       }  
       multiple += k;   
       } 
    }
}