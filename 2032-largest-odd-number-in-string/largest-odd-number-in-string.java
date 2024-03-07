class Solution {
    public String largestOddNumber(String num) {
        int j = num.length()-1;
        while(j>=0) {
            int r_num = num.charAt(j);
            if(r_num % 2 != 0) break;
            j--;
        }
        // if(i > j) return "";
        return num.substring(0,j+1);
    }
}