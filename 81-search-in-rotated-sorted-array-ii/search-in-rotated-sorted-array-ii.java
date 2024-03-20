class Solution {
    public boolean search(int[] nums, int target) {
    
        int n = nums.length;
        int st = 0, end = n-1;

        while(st <= end) {
            int mid = (st+end)/2;
            if(nums[mid] == target) return true;

            // excluding duplicate element
            if(nums[mid] == nums[st] && nums[mid] == nums[end]) {
                st++;
                end--;
                continue;
            }

            // left sorted array
            if(nums[st] <= nums[mid]) {
                if( target >= nums[st] && target < nums[mid]) end = mid-1;
                else st = mid+1;
            } else {
                if(target >= nums[mid] && target <= nums[end]) st = mid+1;
                else end = mid-1;
            }
        }
        return false;
    }
}