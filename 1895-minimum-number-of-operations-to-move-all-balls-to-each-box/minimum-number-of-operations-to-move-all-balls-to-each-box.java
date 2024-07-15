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

        for(int i = 0; i < n; i++) {
            ans[i] = countOnes(boxes, i, n);
        }

        return ans;
    }
}