class Solution {
    int findSum(int[] arr, int i, int j) {
        int sum = 0;
        while(i < j) {
            sum += arr[i];
            i++;
        }
        return sum;
    }
    public double findMaxAverage(int[] nums, int k) {
        int sum = findSum(nums, 0, k);
        int p = 0, q = k;
        int n = nums.length;
        int temp = sum;

        while(q < n) {
            temp = temp + nums[q] - nums[p];
            q++;
            p++;
            sum = Math.max(sum, temp);
        }
        
        return sum/(k*1.0);
    }
}