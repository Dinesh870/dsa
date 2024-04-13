class Solution {
    int[] leftSmaller(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            ans[i] = st.size() > 0 ? st.peek()+1 : 0;
            st.push(i);                                                                             
        }
        return ans;
    }
    int[] rightSmaller(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            ans[i] = st.size() > 0 ? st.peek()-1 : n-1;
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;

        int[] leftS = leftSmaller(heights);
        int[] rightS = rightSmaller(heights);

        for(int i = 0; i < n; i++) {
            int t = (rightS[i] - leftS[i]+1) * heights[i];
            ans = Math.max(ans, t);
        }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int ans = 0;

        for(char[] i : matrix) {
            int k = 0;
            for(char j : i) {
                if(j=='1') heights[k]++;
                else heights[k] = 0;
                k++;
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }
}