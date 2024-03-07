class Solution {
    public String largestOddNumber(String num) {
        int i = 0, j = num.length()-1;
        while(i <= j) {
            // int l_num = num.charAt(i);
            int r_num = num.charAt(j);
            // if(l_num % 2 == 0) i++;
            if(r_num % 2 == 0) j--;

            if(r_num % 2 != 0) break;
        }
        if(i > j) return "";
        return num.substring(i,j+1);
    }
}