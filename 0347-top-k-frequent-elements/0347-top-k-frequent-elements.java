class Solution {

    class pairs implements Comparable<pairs>{
    int ele;
    int freq;
    public pairs(int ele, int freq) {
        this.ele = ele;
        this.freq = freq;
    }

    public int compareTo(pairs p) {
        if (freq == p.freq) return p.ele-ele;
        return freq - p.freq;
    }
}
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<pairs> pq = new PriorityQueue<>();
        for(int ele : map.keySet()){
            pq.add(new pairs(ele, map.get(ele)));
            if(pq.size() > k){
                pq.remove();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            pairs p = pq.poll();
            res[i] = p.ele;
        }
        return res;
    }
}