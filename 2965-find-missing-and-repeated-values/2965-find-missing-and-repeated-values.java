class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        HashSet<Integer> set = new HashSet<>();
        int n = grid.length;
        
        int[] arr = new int[2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!set.contains(grid[i][j])){
                    set.add(grid[i][j]);
                }else{
                    arr[0] = grid[i][j];
                }
            }
        }
        for(int i = 1; i <= n*n; i++){
            if(!set.contains(i)){
                arr[1] = i;
                break;
            }
        }
        return arr;
    }
}