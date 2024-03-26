class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // method 1: T.C. = O(n*n), S.C. = O(1)
        // for(int i = 0; i < n; i++) {
        //     int flag = 0;
        //     for(int j = i+1; j < n; j++) {
        //         if(nums[i] < nums[j]) {
        //             flag = 1;
        //             ans[i] = nums[j];
        //             break;
        //         }
        //     }
        //     if(flag == 0) {
        //         for(int j = 0; j < i; j++) {
        //             if(nums[i] < nums[j]) {
        //                 flag = 1;
        //                 ans[i] = nums[j];
        //                 break;
        //             }
        //         }
        //     }
        //     if(flag == 0) ans[i] = -1;
        // }
        // return ans;

        // method 2: using stack
        Stack<Integer> st = new Stack<>();
        int k = n-1;
        for(int i = 2*n-1; i >= 0; i--) {
            if(st.isEmpty()) st.push(i);
            else {
                while(!st.isEmpty() && nums[st.peek()%n] <= nums[i%n]) {
                    st.pop();
                }
                ans[i%n] = st.size() > 0 ? nums[st.peek()%n] : -1;
                st.push(i);
            }
        }
        return ans;
    }
}