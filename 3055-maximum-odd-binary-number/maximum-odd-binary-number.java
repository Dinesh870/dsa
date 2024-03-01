class Solution {
    public String maximumOddBinaryNumber(String s) {
        int one = 0;
        int n = s.length();

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') one++;
        }
        int zero = n - one;
        s = "";
        for(int i = 0; i < one-1; i++) s = s + "1";
        for(int i = 0; i < zero; i++) s = s + "0";
        System.out.println(s);
        s = s + "1";
        return s;
    }
}