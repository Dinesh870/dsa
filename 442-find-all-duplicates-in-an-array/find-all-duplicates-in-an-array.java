class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // Map<Integer, Integer> map = new HashMap<>();

        // for(int i : nums) {
        //     if(!map.containsKey(i)) map.put(i,1);
        //     else {
        //         int x = map.get(i);
        //         map.put(i,x+1);
        //     }
        // }

        // map.forEach((key,val)->{
        //     if(val==2) ans.add(key);
        // });
        // return ans;

        int n = nums.length;
        int add = n;
        // if(n==1) return ans;

        for(int i = 0; i < n; i++) {
            if(nums[Math.abs(nums[i])-1] >= 0) { // not visited
                nums[Math.abs(nums[i])-1] *= -1;
            }else {
                ans.add(Math.abs(nums[i]));
            }
        }
        return ans;
}
}
