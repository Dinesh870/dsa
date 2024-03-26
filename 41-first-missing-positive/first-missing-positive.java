class Solution {
    public int firstMissingPositive(int[] nums) {
        // brute force
        // int ans = 0;
        // for(int i = 1; i <= 1e5; i++) {
        //     ans = i;
        //     boolean flag = true;
        //     for(int j = 0; j < nums.length; j++) {
        //         if(i==nums[j]) {
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if(flag) return ans; 
        // }
        // return ans+1;

        // better
        // Arrays.sort(nums);
        // int ans = 1;
        // for(int i = 0; i < nums.length; i++) {
        //     if(nums[i] <= 0) continue;
        //     if(i+1 < nums.length && nums[i] == nums[i+1]) continue;
        //     if(nums[i] != ans) return ans;
        //     else ans++;
        // }
        // return ans;

        // Best solution
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) continue;
            set.add(nums[i]);
            max = Math.max(nums[i], max);
        }
        for(int i = 1; i <= 1e5; i++) {
            if(!set.contains(i)) return i;
        }
        return max+1;
    }
}