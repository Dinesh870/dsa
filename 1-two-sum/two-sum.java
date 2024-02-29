class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int len = nums.length;
        // int[] arr = new int[2];
        // for(int i = 0; i < len; i++){

        // for(int j = i+1; j < len; j++){
        // if(nums[i] + nums[j] == target){
        // arr[0] = i;
        // arr[1] = j;
        // break;
        // }
        // }
        // }
        // return arr;

        // method 2: using hashtable
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] ans = { -1 };
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(target - nums[i])) {
                ans = new int[] { mp.get(target - nums[i]), i };
                return ans;
            } else {
                mp.put(nums[i], i);
            }
        }
        return ans;
    }
}