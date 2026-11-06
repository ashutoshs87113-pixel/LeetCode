class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int left, int right) {

        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;

        int count = 0;

        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += merge(nums, mid, left, right);

        return count;
    }

    int merge(int[] nums, int mid, int left, int right) {

        int j = mid + 1;
        int count = 0;

        for (int i = left; i < mid + 1; i++) {
            while (j <= right && (long) nums[i] > nums[j] * 2L) {
                j++;
            }
            count += j - (mid + 1);
        }

        int i = left;
        j = mid + 1;
        int k = 0;

        int[] ans = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                ans[k++] = nums[i++];
            } else {
                ans[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            ans[k++] = nums[i++];
        }
        while (j <= right) {
            ans[k++] = nums[j++];
        }
        for (int p = 0; p < ans.length; p++) {
            nums[left + p] = ans[p];
        }
        return count;
    }
}