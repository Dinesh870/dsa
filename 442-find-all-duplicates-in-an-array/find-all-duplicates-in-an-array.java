class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            if(!map.containsKey(i)) map.put(i,1);
            else {
                int x = map.get(i);
                map.put(i,x+1);
            }
        }

        map.forEach((key,val)->{
            if(val==2) ans.add(key);
        });
        return ans;
}
}
