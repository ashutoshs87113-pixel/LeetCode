class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int hi = arr.length-1;
        int lo = 0;

        while(lo <= hi){
            int mid = lo+(hi - lo)/2;

            if(arr[mid] - (mid+1) < k){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
       
       return hi + 1 + k;
    }
}