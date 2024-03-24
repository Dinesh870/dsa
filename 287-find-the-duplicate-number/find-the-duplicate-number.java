class Solution {
    public int findDuplicate(int[] nums) {
        // method 1: sorting
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[i+1]) return nums[i];
        }
        return -1;

        // method 2: two pointer
        // int p = nums[0];
        // int q = nums[p];

        // while(p!=q) {
        //     p = nums[p];
        //     q = nums[q];
        // }

        
        // return -1;
    }
}