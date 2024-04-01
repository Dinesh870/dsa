class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        // System.out.println(s);
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c != ' ') count++;
            else return count;
        }
        return count;
    }
}