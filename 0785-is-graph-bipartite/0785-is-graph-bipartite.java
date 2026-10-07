class Solution {
    
    public boolean bfs(int start, int[][] graph, int[] color) {
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        color[start] = 1;
        
        while(q.size() > 0) {
            
            int vertex = q.remove();
            
            for(int ele : graph[vertex]) {
                
                // Not colored yet
                if(color[ele] == 0) {
                    color[ele] = 3 - color[vertex];
                    q.add(ele);
                }
                
                // Same color on both ends
                else if(color[ele] == color[vertex]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        
        int[] color = new int[n];
        
        for(int i = 0; i < n; i++) {
            
            // New connected component
            if(color[i] == 0) {
                
                if(!bfs(i, graph, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}