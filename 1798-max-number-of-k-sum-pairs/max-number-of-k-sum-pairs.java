class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;



        // method 3: T.C. = O(n), S.C. = O(n)
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else {
                int x = map.get(nums[i]);
                map.put(nums[i], x+1);
            }
        }

        for(int i = 0; i < n; i++) {
            int key = k - nums[i];
            if(!map.containsKey(key)) continue;

            if(key == nums[i] && map.get(key) == 1) continue;

            if (map.get(key) > 0 && map.get(nums[i]) > 0) {
                cnt++;
                map.put(key,map.get(key)-1);
                map.put(nums[i],map.get(nums[i])-1);
            }
        }
        return cnt;
    }
}