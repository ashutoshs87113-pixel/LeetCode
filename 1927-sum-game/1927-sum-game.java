class Solution {
    public boolean sumGame(String s) {

        int n = s.length();

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        for(int i = 0; i < n/2; i++){
            if(s.charAt(i) == '?') leftQ++;
            else
            leftSum += s.charAt(i) - '0';
        }

        for(int i = n-1; i >= n/2; i--){
            if(s.charAt(i) == '?') rightQ++;
            else
            rightSum += s.charAt(i) - '0';
        }

         int sumDiff = leftSum - rightSum;
         int qdiff = rightQ - leftQ;

     return 2 * sumDiff != 9 * qdiff;
        
    }
}