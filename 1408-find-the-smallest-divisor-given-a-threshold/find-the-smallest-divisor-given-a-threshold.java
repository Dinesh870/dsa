class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        int divisor = 1;
        int max = 0;
        for(int i : nums) max = Math.max(i, max);

        // method 1:
        // while(divisor <= max) {
        //     int totalSum = 0;
        //     for(int i : nums) {
        //         totalSum += Math.ceil((i/(divisor+0.0)));
        //     }
        //     if(totalSum <= threshold) return divisor;
        //     divisor++;
        // }
        // return 0;


        // method 2:
        int st = 0, end = max;
        while(st<=end) {
            int mid = st + (end-st)/2;
            int totalSum = 0;
            for(int i : nums) {
                totalSum += Math.ceil((i/(mid+0.0)));
            }
            if(totalSum <= threshold) {
                divisor = mid;
                end = mid-1;
            }else st = mid+1;
        }
        return divisor;

    }
}