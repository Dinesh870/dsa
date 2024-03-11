class Solution {
    public String customSortString(String order, String s) {
        // Map<Character,Integer> map = new HashMap<>();
        // // count no of character
        // for(int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if(!map.containsKey(ch)) map.put(ch,1);
        //     else {
        //         int x = map.get(ch);
        //         map.put(ch, x+1);
        //     }
        // }

        // // sorting
        // s = "";
        // for(int i = 0; i < order.length(); i++) {
        //     char ch = order.charAt(i);
        //     if(!map.containsKey(ch)) continue;
        //     int f = map.get(ch);
        //     while(f > 0) {
        //         s += ch;
        //         f--;
        //     }
        //     map.remove(ch);
        // }
        // for(var ch : map.keySet()){
        //     int x = map.get(ch);
        //     while(x > 0) {
        //         s += ch;
        //         x--;
        //     }
        // }

        // return s;

        // method 2:
        int[] store = new int[26];
        int sl = s.length();
        for(int i = 0; i < sl; i++) {
            char ch = s.charAt(i);
            store[ch-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        int ol = order.length();
        for(int i = 0; i < ol; i++) {
            char ch = order.charAt(i);
            // int x = store[ch-'a'];
            while(store[ch-'a'] > 0) {
                sb.append(ch);
                store[ch-'a']--;
            }
        }
        for(int i = 0; i < 26; i++) {
            while(store[i] > 0) {
                char ch = (char)(97 + i);
                sb.append(ch);
                store[i]--;
            }
        }
        return sb.toString();
    }
}