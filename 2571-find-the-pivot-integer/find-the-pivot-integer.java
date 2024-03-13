class Solution {
    public int pivotInteger(int n) {
        int[] pref = new int[n+1];
        for(int i = 1; i<= n; i++) {
            pref[i] = pref[i-1] + i;
        }
        int sum = 0;
        for(int i = n; i > 0; i--) {
            sum += i;
            if(pref[i] == sum) return i;
        }

        return -1;
    }
}