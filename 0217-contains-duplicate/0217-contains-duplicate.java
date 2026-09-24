class Solution {
    public boolean containsDuplicate(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        if (set.size() == n)
            return false;

        return true;
    }
}