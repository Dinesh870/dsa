class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0;

        for(int j = 0; j < nums.length; j++) {
            if(!map.containsKey(nums[j])) {
                map.put(nums[j],1);
                if(map.get(nums[j]) <= k) ans = Math.max(ans, j-i+1);
            }
            else {
                int x = map.get(nums[j]);
                map.put(nums[j],x+1);
                while(map.get(nums[j]) > k) {
                    x = map.get(nums[i]);
                    map.put(nums[i], x-1);
                    i++;
                }
                ans = Math.max(ans,j-i+1);
            }
        }
        return ans;

    }
}