class Solution {
    public String maximumOddBinaryNumber(String s) {
        // int one = 0;
        // int n = s.length();

        // for(int i = 0; i < n; i++) {
        //     if(s.charAt(i) == '1') one++;
        // }
        // int zero = n - one;
        // s = "";
        // for(int i = 0; i < one-1; i++) s = s + "1";
        // for(int i = 0; i < zero; i++) s = s + "0";
        // System.out.println(s);
        // s = s + "1";
        // return s;

        // method 2:
        char[] ch = s.toCharArray();
        int one = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(ch[i] == '1') one++;
        }
        for(int i = 0; i < one-1; i++) ch[i] = '1';
        for(int i = one-1; i < n; i++) ch[i] = '0';
        ch[n-1] = '1';
        return new String(ch);
    }
}