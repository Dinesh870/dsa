class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();

        int n = s.length();
        for(int i = 0; i < n; i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if(map.containsKey(sch)) {
                if(map.get(sch) != tch) return false;
            } 
            else if(map.containsValue(tch)) {
                return false;
            }else {
                map.put(sch, tch);
            }
        }
        return true;
    }
}