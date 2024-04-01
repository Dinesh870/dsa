class Solution {
    public int lengthOfLastWord(String s) {
        // s = s.trim();
        // // System.out.println(s);
        // int count = 0;
        // for(int i = s.length()-1; i >= 0; i--) {
        //     char c = s.charAt(i);
        //     if(c != ' ') count++;
        //     else return count;
        // }
        // return count;

        // method 2:
        // ignoring the white space

        int i = s.length()-1;
        while(i >= 0 && s.charAt(i) == ' ') i--;

        int cnt = 0;
        while(i >= 0 && s.charAt(i) != ' ') {
            cnt++;
            i--;
        }
        return cnt;
    }
}