class Solution {
    public boolean isPathCrossing(String path) {
        int n = path.length();

        Map<Character,Pair<Integer,Integer>> moves = new HashMap<>();
        moves.put('E', new Pair(1,0));
        moves.put('W', new Pair(-1,0));
        moves.put('N', new Pair(0,1));
        moves.put('S', new Pair(0,-1));

        Set<Pair<Integer,Integer>> visited = new HashSet<>();
        visited.add(new Pair(0,0));

        int x = 0, y = 0;

        for(int i = 0; i < n; i++) {
            char ch = path.charAt(i);

            Pair<Integer,Integer> curr = moves.get(ch);

            x += curr.getKey();
            y += curr.getValue();

            if(visited.contains(new Pair(x,y))) return true;

            visited.add(new Pair(x,y));
        }
        return false;
    }
}