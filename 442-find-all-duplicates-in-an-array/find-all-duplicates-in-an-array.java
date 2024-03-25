class Solution {
    
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1] >= 0) { // not visited
                nums[Math.abs(nums[i])-1] *= -1;
            }else { // already visited
                ans.add(Math.abs(nums[i]));
            }
        }
        return ans;
}
}
