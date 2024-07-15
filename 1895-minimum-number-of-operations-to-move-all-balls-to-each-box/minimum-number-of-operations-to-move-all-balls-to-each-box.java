class Solution {
    int countOnes(String s, int i, int n) {
        int j = i;
        int c = i;
        int ones = 0;

        while(j+1 < n) {
            if(s.charAt(j+1) == '1') ones += Math.abs(j+1 -c);
            j++;
        }
        while(i-1 >= 0) {
            if(s.charAt(i-1) == '1') ones += Math.abs(i-1 - c);
            i--;
        }

        return ones;
    }
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        // method 1: 
        // for(int i = 0; i < n; i++) {
        //     ans[i] = countOnes(boxes, i, n);
        // }

        // return ans;

        // method 2:
        int[] left = new int[n];
        int[] right = new int[n];

        int cnt = boxes.charAt(0) - '0';

        // finding left possible way to move the boxes
        for(int i = 1; i < n; i++) {
            left[i] = left[i-1] + cnt;
            cnt += (boxes.charAt(i) - '0');
        }

        // finding right possible way to move the boxes
        cnt = boxes.charAt(n-1) - '0';
        for(int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] + cnt;
            cnt += (boxes.charAt(i) - '0');
        }

        // ans = left + right
        for(int i = 0; i < n; i++) {
            ans[i] = left[i] + right[i];
        }
        return ans;
    }
}