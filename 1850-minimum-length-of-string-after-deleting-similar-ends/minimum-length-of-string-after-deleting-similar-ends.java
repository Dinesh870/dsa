class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0, j = n-1;
        if(n==1) return 1;
        while (i < j) {
            char prefix = s.charAt(i);
            char suffix = s.charAt(j);
            
            if(prefix != suffix) return j-i+1;
            // finding all prefix
            i++;
            j--;
            while(i < j) {
                if(s.charAt(i) != prefix) break;
                i++;
            }
            // finding suffix
            while(i < j) {
                if(s.charAt(j) != suffix) break;
                j--;
            }
            if(i==j && s.charAt(i) != prefix && s.charAt(i) != suffix) return 1;
        }
        // if(i==j) return j-i+1;
        return 0;
    }
}