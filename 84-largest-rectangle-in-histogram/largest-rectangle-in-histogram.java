class Solution {
    int[] leftSmaller(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            if(st.isEmpty()) {
                st.push(i);
                ans[i] = 0;
            } else {
                while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
                ans[i] = st.size() > 0 ? st.peek()+1 : 0;
                st.push(i);                                                                             
            }
        }
        return ans;
    }
    int[] rightSmaller(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--) {
            if(st.isEmpty()) {
                st.push(i);
                ans[i] = n-1;
            } else {
                while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
                ans[i] = st.size() > 0 ? st.peek()-1 : n-1;
                st.push(i);
            }
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;

        // Brute force
        // for(int i = 0; i < n; i++) {
        //     int left = heights[i];

        //     for(int j = i; j < n; j++) {
        //         int right = heights[j];
        //         int h = Math.min(left, right);
        //         left = h;
        //         int w = j-i+1;

        //         int ar = h*w;
        //         ans = Math.max(ans, ar);
        //     }
        // }
        // return ans;

        // method 2:
        // for(int i = 0; i < n; i++) {
        //     // right smaller
        //     int rsm = heights[i];
        //     int j = i;
        //     int r = i;
        //     while(j < n && heights[j] >= rsm) {
        //         r = j;
        //         j++;
        //     }

        //     // left smaller
        //     int k = i;
        //     int l = i;
        //     while(k >= 0 && heights[k] >= rsm) {
        //         l = k;
        //         k--;
        //     }
        //     int h = rsm;
        //     int w = r-l+1;
        //     int ar = h*w;
        //     ans = Math.max(ans, ar);
        // }
        // return ans;

        // method 3:

        int[] leftS = leftSmaller(heights);
        for(int i : leftS) System.out.print(i+" ");
        System.out.println();
        int[] rightS = rightSmaller(heights);
        for(int i : rightS) System.out.print(i+" ");
        System.out.println();

        // int ans = 0;
        for(int i = 0; i < n; i++) {
            int t = (rightS[i] - leftS[i]+1) * heights[i];
            System.out.print(t+" ");
            ans = Math.max(ans, t);
        }
        return ans;

    }
}