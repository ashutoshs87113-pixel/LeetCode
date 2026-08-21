class Solution {
    public int largestRectangleArea(int[] arr) {

        int n = arr.length;

        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        st.push(n - 1);
        nse[n - 1] = n; // calculation purpose

        for (int i = n - 2; i >= 0; i--) {

            while (st.size() > 0 && arr[st.peek()] >= arr[i])
                st.pop();

            if (st.size() == 0)
                nse[i] = n; // calculation purpose
            else
                nse[i] = st.peek();
            st.push(i);
        }

        while (st.size() > 0)
            st.pop();

        int[] pse = new int[n];
        st.push(0);
        pse[0] = -1;
        for (int i = 1; i < n; i++) {

            while (st.size() > 0 && arr[st.peek()] >= arr[i])
                st.pop();

            if (st.size() == 0)
                pse[i] = -1; // calculation purpose
            else
                pse[i] = st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = arr[i] * (nse[i] - pse[i] - 1);

            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}