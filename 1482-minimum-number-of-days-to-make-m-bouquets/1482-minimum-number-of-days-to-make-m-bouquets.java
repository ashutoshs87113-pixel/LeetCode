class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length;

        if((long) m*k > n) return -1;

        int lo = Integer.MAX_VALUE;
        int hi = 0;
        int ans = -1;
        for(int i = 0; i < n; i++){
            if(bloomDay[i] > hi) hi = bloomDay[i];
            if(bloomDay[i] < lo) lo = bloomDay[i];
        }
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;

            if(isPossible(bloomDay, mid, m , k)){
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[]bloomDay, int mid, int m, int k){
        
        int count = 0;
        int bouquet = 0;

        for(int i = 0; i < bloomDay.length; i++){

            if(bloomDay[i] <= mid){
                count++;
                if(count == k){
                    bouquet++;
                    count = 0;
                }
            }
            else{
                count = 0;
            }
        }
        if(bouquet >= m) return true;
        else
        return false;
    }
}