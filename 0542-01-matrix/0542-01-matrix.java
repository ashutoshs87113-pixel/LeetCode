class pair{
    int row;
    int col;

    pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {

       Queue<pair> q = new LinkedList<>();

       int m = mat.length;
       int n = mat[0].length;

       int[][] dist = new int[m][n];

       for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(mat[i][j] == 0){
                dist[i][j] = 0;
                q.add(new pair(i,j));
            }
            else{
                dist[i][j] = -1;
            }
        }
       } 
       int[] dr = {-1 , 1, 0, 0};
       int[] dc = {0 , 0, -1, 1};

       while(q.size() > 0){
        pair front = q.remove();
        int row = front.row;
        int col = front.col;

        for(int i = 0; i < 4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n ){
                if(dist[nr][nc] == -1){
                    dist[nr][nc] = dist[row][col] + 1;
                    q.add(new pair(nr, nc));
                }
            }
        }
       }
       return dist;
    }
}