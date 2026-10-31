class Solution {

    class triplet implements Comparable<triplet>{
    int dist;
    int x;
    int y;
    triplet(int d,int x,int y){
        this.dist=d;
        this.x=x;
        this.y=y;
    }

    public int compareTo(triplet t) {
        return (int) (this.dist-t.dist);
    }
}

    public int[][] kClosest(int[][] points, int k) {
       

        PriorityQueue<triplet> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int[] point : points){

            int x = point[0];
            int y = point[1];
            int dist = x*x + y*y;
           pq.add(new triplet(dist,x,y));
           if(pq.size()>k){
               pq.remove();
           }
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            triplet top = pq.remove();
            res[i][0] = top.x;
            res[i][1] = top.y;
            
        }
        return res;
    
    }
}