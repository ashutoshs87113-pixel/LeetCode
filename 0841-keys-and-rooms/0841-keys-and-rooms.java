class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Queue<Integer> q = new LinkedList<>();
        int n = rooms.size();

        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;

        while(q.size() > 0){
            int front = q.remove();
            for(int ele : rooms.get(front)){
                if(!visited[ele]){
                    q.add(ele);
                    visited[ele] = true;
                }
            }
        }
        for(boolean flag : visited){
            if(!flag) return false;
        }
        return true;
    }
}