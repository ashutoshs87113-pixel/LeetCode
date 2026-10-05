class pair{
    int row;
    int col;

    pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        Queue<pair> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1) {
                grid[i][0] = -1;
            q.add(new pair(i,0));
            }
            

            if(grid[i][n-1] == 1){
             grid[i][n-1] = -1;
            q.add(new pair(i,n-1));
            }
        }

         for(int j = 0; j < n; j++){
            if(grid[0][j] == 1) {
            grid[0][j] = -1;
            q.add(new pair(0,j));
         }
            if(grid[m-1][j] == 1) {
            grid[m-1][j] = -1;
            q.add(new pair(m-1,j));
        }
    }

        while(q.size() > 0){

            pair front = q.remove();
            int row = front.row;
            int col = front.col;

            // left

            if(col - 1 >= 0 && grid[row][col - 1] == 1){
                grid[row][col-1] = -1;
                q.add(new pair(row, col - 1));
            }

            //right

            if(col + 1 < n && grid[row][col + 1] == 1){
                grid[row][col+1] = -1;
                q.add(new pair(row, col + 1));
            }

            // up

            if(row - 1 >= 0 && grid[row - 1][col] == 1){
                grid[row - 1][col] = -1;
                q.add(new pair(row -1 , col));
            }

            // down

            if(row  + 1< m && grid[row + 1][col] == 1){
                grid[row + 1][col] = -1;
                q.add(new pair(row +1 , col));
            }
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) count++;
            }
        }
        return count;
    }
}