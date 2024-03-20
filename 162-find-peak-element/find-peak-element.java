class Solution {
    public int findPeakElement(int[] nums) {
        // method 1: Brute force: T.C. = O(n) , S.C. = O(1)
        int n = nums.length;
        if(n == 1) return 0;
        if(n == 2) {
            if(nums[0] > nums[1]) return 0;
            else return 1;
        }
        //     if(nums[0] > nums[1]) return 0;
        // for(int i = 1; i < n-1; i++) {
        //     if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        // }
        // if(nums[n-1] > nums[n-2]) return n-1;
        // return -1;

        // method 2: Binary search

        int st = 0, end = n-1;

        while(st <= end) {
            int mid = (st+end)/2;
            if(mid==n-1) {
                if(nums[mid] > nums[mid-1]) return mid;
            }
            if(mid == 0) {
                if(nums[mid] > nums[mid+1]) return mid;
            }
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) return mid;
            if(nums[mid] < nums[mid+1]) st = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}