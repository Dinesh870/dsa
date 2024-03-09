class Solution {
    double findSum(int[] arr, int i, int j) {
        double sum = 0;
        while(i < j) {
            sum += arr[i];
            i++;
        }
        return sum;
    }
    public double findMaxAverage(int[] nums, int k) {
        double sum = findSum(nums, 0, k);
        int p = 0, q = k;
        int n = nums.length;
        double temp = sum;

        while(q < n) {
            temp = temp + nums[q] - nums[p];
            q++;
            p++;
            System.out.print(sum + " ");
            sum = Math.max(sum, temp);
        }
        return sum/k;
    }
}