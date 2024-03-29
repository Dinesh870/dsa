class Solution {
    int findMax(int[] nums) {
        int max = 1;
        for(int i : nums) max = Math.max(i,max);
        return max;
    }
    public long countSubarrays(int[] nums, int k) {
        int n= nums.length, max = findMax(nums);
        long ans = 0;

        // method 1: Brute force
        // for(int i = 0; i < n; i++) {
        //     for(int j = i; j < n; j++) {
        //         if(nums[j] == max) cnt++;
        //         if(cnt >= k) ans++;
        //     }
        // }
        // return ans;

        // method 2: Sliding window
        int start = 0, maxElementsInWindow = 0;
        for(int end = 0; end < n; end++) {
            if(nums[end] == max) maxElementsInWindow++;
            while(maxElementsInWindow==k) {
                if(nums[start] == max) maxElementsInWindow--;
                start++;
            }
            ans += start;
        }
        return ans;

    }
}