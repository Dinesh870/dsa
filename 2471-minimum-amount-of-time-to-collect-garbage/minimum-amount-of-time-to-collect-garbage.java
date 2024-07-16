class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int m = 0, p = 0, g = 0;

        int n = garbage.length;
        boolean m_first = false, p_first = false, g_first = false;

        for(int i = n-1; i >= 0; i--) {
            String s = garbage[i];

            for(int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if(ch == 'M') {
                    m_first = true;
                    m++;
                } else if(ch == 'P') {
                    p_first = true;
                    p++;
                } else {
                    g_first = true;
                    g++;
                }
            }

            if(i-1 >= 0) {
                if(m_first) m += travel[i-1];
                if(p_first) p += travel[i-1];
                if(g_first) g += travel[i-1];
            }
        }

        // for p
        // first = false;
        // for(int i = n-1; i >= 0; i--) {
        //     String s = garbage[i];

        //     int cnt = 0;
        //     for(int j = 0; j < s.length(); j++) {
        //         if(s.charAt(j) == 'P') {
        //             first = true;
        //             cnt++;
        //         }
        //     }

        //     p += cnt;
        //     if(first && i-1 >= 0) {
        //         p += travel[i-1];
        //     }
        // }

        // // for g
        // first = false;
        // for(int i = n-1; i >= 0; i--) {
        //     String s = garbage[i];

        //     int cnt = 0;
        //     for(int j = 0; j < s.length(); j++) {
        //         if(s.charAt(j) == 'G') {
        //             first = true;
        //             cnt++;
        //         }
        //     }

        //     g += cnt;
        //     if(first && i-1 >= 0) {
        //         g += travel[i-1];
        //     }
        // }

        return m+p+g;
    }
}