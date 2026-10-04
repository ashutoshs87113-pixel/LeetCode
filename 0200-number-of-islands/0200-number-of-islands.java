class pair{
    int r;
    int c;
   pair(int r, int c){
    this.r = r;
    this.c = c;
   }
}

class Solution {

    public void bfs(char[][] grid, int i, int j,boolean[][] visited){
        Queue<pair> q = new LinkedList<>();

        q.add(new pair(i , j));
        visited[i][j] = true;

        int[] dr ={-1, 1, 0, 0};
        int[] dc = {0 , 0, -1, 1};

        while(q.size() > 0){
            pair front = q.remove();
            int r = front.r;
            int c = front.c;

            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nr < grid.length && 
                nc >= 0 && nc < grid[0].length &&
                 grid[nr][nc] == '1' && 
                 !visited[nr][nc]){
                    q.add(new pair(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
              if(grid[i][j] == '1' && !visited[i][j]){
                count++;
                bfs(grid, i, j, visited);
              }
            }
        }
        return count;

    }
}