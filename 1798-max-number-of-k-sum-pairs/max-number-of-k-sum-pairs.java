class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;

        // method 1: Brute force, T.C. = O(n^2)
        // for(int i = 0; i < n; i++) {
        //     if(nums[i] == -1) continue;
        //     for(int j = i+1; j < n; j++) {
        //         if(nums[j] == -1) continue;
        //         if(nums[i] + nums[j] == k) {
        //             cnt++;
        //             nums[i] = -1;
        //             nums[j] = -1;
        //             break;
        //         }
        //     }
        // }
        // return cnt;

        // method 2: T.C. = O(nlog(n) + n)
        // Arrays.sort(nums);
        // int p = 0, q = n-1;

        // while(p < q) {
        //     if(nums[p] == -1) p++;
        //     if(nums[q] == -1) q--;

        //     int sum = nums[p] + nums[q];

        //     if(sum == k) {
        //         nums[p] = -1;
        //         nums[q] = -1;
        //         cnt++;
        //         p++;
        //         q--;
        //     }

        //     if(sum > k) q--;
        //     if(sum < k) p++;
        // }
        // return cnt;

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

            int x = map.get(key);
            int y = map.get(nums[i]);
            if(key == nums[i] && map.get(key) == 1) continue;
            if (x > 0 && y > 0) {
                System.out.print(x+" "+y+",");
                cnt++;
                map.put(key,map.get(key)-1);
                map.put(nums[i],map.get(nums[i])-1);
            }
        }
        return cnt;
    }
}