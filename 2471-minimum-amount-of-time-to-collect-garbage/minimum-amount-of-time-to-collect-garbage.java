class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;

        int n = garbage.length;
        boolean m_first = false, p_first = false, g_first = false;

        for(int i = n-1; i >= 0; i--) {
            String s = garbage[i];

            for(int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if(ch == 'M') m_first = true;
                else if(ch == 'P') p_first = true;
                else g_first = true;
                ans++;
            }

            if(i-1 >= 0) {
                if(m_first) ans += travel[i-1];
                if(p_first) ans += travel[i-1];
                if(g_first) ans += travel[i-1];
            }
        }

        return ans;
    }
}