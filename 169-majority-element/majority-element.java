class Solution {
    public int majorityElement(int[] nums) {
        int l = nums.length;
        int max = 1, count = 1, indexf = 0,indexI=0,ind = 0;
        Arrays.sort(nums);

        for(int i = 0; i < l-1; i++){
            if(nums[i]==nums[i+1]){
                count++;
                indexI = i;
            }
            else{
                if(count > max){
                    max = count;
                    count = 1;
                    ind = indexI;
                }
            }
        }
        if(count > max){
            max = count;
            if(max > l/2)
            indexf = indexI;
        }else{
           if(max > l/2) indexf = ind;
        }

        return nums[indexf];

        // method 2: using HashMap
        // Map<Integer,Integer> map = new HashMap<>();
        // int n = nums.length;
        // for(int i= 0; i < n; i++) {
        //     if(!map.containsKey(nums[i])) map.put(nums[i], 1);
        //     else {
        //         int f = map.get(nums[i]);
        //         map.put(nums[i], f+1);
        //     }
        // }

        // for(int i : map.keySet()) {
        //     if(map.get(i) > n/2) return i;
        // }
        // return 0;
    }
}