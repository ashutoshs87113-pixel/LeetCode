class Solution {
    public int mySqrt(int n) {
        
        if(n==0) return 0;
        int ans = 0;
        int low = 1; 
        int high = n;

        while(low<=high){
            int mid = low+(high - low)/2;
            if((long)mid*mid > n) high = mid-1;
            else{
                ans = mid;
                low = mid+1;
            }
        }
        return ans;
    }
}