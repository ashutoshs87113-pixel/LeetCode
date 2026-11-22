class Solution {
    public int beautySum(String s) {
        
        int sum = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            HashMap<Character, Integer> map = new HashMap<>();

            for(int j = i; j < n; j++){
                map.put(s.charAt(j) , map.getOrDefault(s.charAt(j) ,0)+1);

                int max = 0;
                int min = Integer.MAX_VALUE;

                for(int freq : map.values()){
                    max = Math.max(max, freq);
                    min = Math.min(min, freq);
                }
                sum += max-min;
            }
        }
        return sum;
    }
}