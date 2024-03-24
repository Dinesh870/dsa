class Solution {
    public int findDuplicate(int[] nums) {
        // method 1: sorting
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length; i++) {
        //     if(nums[i] == nums[i+1]) return nums[i];
        // }
        // return -1;

        // method 2: two pointer
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}