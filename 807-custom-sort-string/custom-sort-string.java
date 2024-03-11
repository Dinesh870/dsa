class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();
        // count no of character
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) map.put(ch,1);
            else {
                int x = map.get(ch);
                map.put(ch, x+1);
            }
        }

        // sorting
        s = "";
        for(int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if(!map.containsKey(ch)) continue;
            int f = map.get(ch);
            while(f > 0) {
                s += ch;
                f--;
            }
            map.remove(ch);
        }
        for(var ch : map.keySet()){
            int x = map.get(ch);
            while(x > 0) {
                s += ch;
                x--;
            }
        }

        return s;
    }
}