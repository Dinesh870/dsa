class Solution {
    void fun(int i, int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        if(i >= nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        fun(i+1, nums, ans, temp);
        int size = temp.size();
        temp.remove(size-1);
        fun(i+1,nums,ans,temp);
    }
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        fun(0, nums, ans, temp);

        int sum = 0;
        for(List<Integer> i : ans) {
            int xor = 0;
            for(Integer j : i) {
                xor ^= j;
                // System.out.print(j+" ");
            }
            sum += xor;
            // System.out.println();
        }

        return sum;
    }
}