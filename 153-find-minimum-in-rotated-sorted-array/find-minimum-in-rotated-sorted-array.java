class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int st = 0, end = n-1;
        int ans = Integer.MAX_VALUE;

        while(st <= end) {
            int mid = (st+end)/2;
            
            if(nums[st] <= nums[mid]) {  // left half sorted
                ans = Math.min(ans, nums[st]);
                st = mid+1;
            }else {  // right half sorted
                ans = Math.min(ans, nums[mid]);
                end = mid-1;
            }
        }
        return ans;
    }
}