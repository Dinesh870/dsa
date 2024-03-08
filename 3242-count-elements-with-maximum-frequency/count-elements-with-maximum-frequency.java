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
        int i = 100;
        while(count[i] == count[i-1]) {
            ans += count[i];
            i--;
        }
        
        return ans+count[i];
    }
}