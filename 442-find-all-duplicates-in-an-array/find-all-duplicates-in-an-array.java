class Solution {
    // method 1: using hashmap
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

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1] >= 0) nums[Math.abs(nums[i])-1] *= -1;    // not visited
            else ans.add(Math.abs(nums[i]));   // already visited
        }
        return ans;
}
}
