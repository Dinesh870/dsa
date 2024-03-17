class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;

        // method 1: Brute force, T.C. = O(n^2)
        // for(int i = 0; i < n; i++) {
        //     if(nums[i] == -1) continue;
        //     for(int j = i+1; j < n; j++) {
        //         if(nums[j] == -1) continue;
        //         if(nums[i] + nums[j] == k) {
        //             cnt++;
        //             nums[i] = -1;
        //             nums[j] = -1;
        //             break;
        //         }
        //     }
        // }
        // return cnt;

        // method 2:
        Arrays.sort(nums);
        int p = 0, q = n-1;
        while(p < q) {
            if(nums[p] == -1) p++;
            if(nums[q] == -1) q--;

            int sum = nums[p] + nums[q];
            if(sum == k) {
                nums[p] = -1;
                nums[q] = -1;
                cnt++;
                p++;
                q--;
            }
            if(sum > k) q--;
            if(sum < k) p++;
        }
        return cnt;
    }
}