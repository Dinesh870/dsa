class Solution {
    // int sqrt(int x) {
    //     if(x == 0 || x == 1) return x;
    //     long st = 1, end = x/2;
    //     long ans = 0;
    //     while(st <= end) {
    //         long mid = st + (end - st)/2;
    //         long y = mid*mid;
    //         if(y==x) return (int)mid;
    //         else if(y>x) end = mid-1;
    //         else {
    //             st = mid+1;
    //             ans = mid;
    //         }
    //     }
    //     return (int)ans;
    // }
    public boolean judgeSquareSum(int n) {
        int c = (int)Math.sqrt(n);
        for(int b = 0; b <= c; b++) {
            int a = (int)Math.sqrt(n-b*b);
            if((a*a + b*b) == n) 
                return true;
        }
        return false;
    }
}