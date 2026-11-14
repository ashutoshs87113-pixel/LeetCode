class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int n = weights.length;

        int lo = 0;
        int hi = 0;
        int ans = -1;

        for(int i = 0; i < n; i++){
            if(weights[i] > lo) lo = weights[i];
            hi+=weights[i];
        }

        while(lo <= hi){

            int mid = lo+(hi - lo)/2;

            if(day(weights, mid) <= days){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid +1;
            }
        }
        return ans;
    }
    public int day(int[] weights, int mid){

        int days = 1; int weight = 0;

        for(int i = 0; i < weights.length; i++){
            if(weights[i]+weight > mid){
                days += 1;
                weight = weights[i];
            }else{
                weight += weights[i];
            }
        }
        return days;
    }
}