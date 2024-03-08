class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int[] count = new int[101];
        for(int i : nums) {
            count[i]++;
        }
        Arrays.sort(count);
        if(count[100] == 1) return n;
        int ans = 0;
        boolean flag = false;
        int i = 100;
        while(count[i] == count[i-1]) {
            ans += count[i];
            flag = true;
            i--;
        }
        if(ans == 0) {
            return count[100];
        }
        return ans+count[i];
    }
}