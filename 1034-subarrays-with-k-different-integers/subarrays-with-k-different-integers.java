class Solution {

    int subarraysWithDistinctIntegerLesserThan_K(int[] nums, int k) {
        if(k < 1) return 0;
        int left = 0, right = 0, cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();

        while(right < nums.length) {
            // expanding the window size
            if(!map.containsKey(nums[right])) map.put(nums[right], 1);
            else {
                int x = map.get(nums[right]);
                map.put(nums[right], x+1);
            }

            // shrinking the window size
            while(map.size() > k) {
                // int y = nums[left];
                int x = map.get(nums[left]);
                // System.out.print(x+" ");
                map.put(nums[left], x-1);
                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                // System.out.print(map.size()+" ");
                left++;
            }

            cnt += (right-left+1);
            right++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        // int n = nums.length;
        // int ans = 0;

        // Brute force
        // for(int i = 0; i < n; i++) {
        //     HashMap<Integer, Integer> map = new HashMap<>();
        //     for(int j = i; j < n; j++) {
        //         if(!map.containsKey(nums[j])) map.put(nums[j], 1);
        //         if(map.size() > k) {
        //             break;
        //         }
        //         if(map.size() == k) {
        //             ans++;
        //         }
        //     }
        // }
        // return ans;

        return subarraysWithDistinctIntegerLesserThan_K(nums, k) - subarraysWithDistinctIntegerLesserThan_K(nums, k-1);
    }
}