class Solution {
    public boolean isIsomorphic(String s, String t) {
        // HashMap<Character,Character> map = new HashMap<>();

        int n = s.length();
        // for(int i = 0; i < n; i++) {
        //     char sch = s.charAt(i);
        //     char tch = t.charAt(i);

        //     if(map.containsKey(sch)) {
        //         if(map.get(sch) != tch) return false;
        //     } 
        //     else if(map.containsValue(tch)) {
        //         return false;
        //     }else {
        //         map.put(sch, tch);
        //     }
        // }
        // return true;

        // method 2: using array
        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for(int i = 0; i < n; i++) {
            int sch = s.charAt(i);
            int tch = t.charAt(i);

            if(map1[sch] != map2[tch]) return false;
            map1[sch] = map2[tch] = i+1;
        }

        return true;
    }
}