class Solution {

    class pair implements Comparable<pair> {
        int k;
        int dist;

        public pair(int k, int dist) {
            this.k = k;
            this.dist = dist;
        }

        public int compareTo(pair p) {
            if (this.dist != p.dist) {
                return Integer.compare(this.dist, p.dist);
            }

            return Integer.compare(this.k, p.k);

        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> ans = new ArrayList<>();
        PriorityQueue<pair> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            int dist = Math.abs(arr[i] - x);
            pq.add(new pair(arr[i], dist));
            if (pq.size() > k)
                pq.remove();

        }
        for (int i = 0; i < k; i++) {
            pair top = pq.remove();
            int res = top.k;
            ans.add(res);
        }
        Collections.sort(ans);
        return ans;
    }
}