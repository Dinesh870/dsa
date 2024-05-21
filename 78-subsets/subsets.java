class Solution {
    void fun(int i, int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        if(i >= nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        // ans.add(temp);
        fun(i+1, nums, ans, temp);
        int idx = temp.size()-1;
        temp.remove(idx);
        fun(i+1, nums, ans, temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        // int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        // int totalSubset = (int) Math.pow(2,n);
        // for(int i = 0; i < totalSubset; i++) {
        // List<Integer> temp = new ArrayList<>();
        //     for(int j = 0; j < n; j++) {
        //         if((i & (1<<j)) != 0)
        //             temp.add(nums[j]);
        //     }
        //     ans.add(temp);
        // }
        // return ans;

        // method 2: using backtracking
        List<Integer> temp = new ArrayList<>();
        fun(0, nums, ans, temp);
        return ans;
    }
}