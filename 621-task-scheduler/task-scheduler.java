class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Map<Character,Integer> map = new HashMap<>();
        // for(var i : tasks) {
        //     if(!map.containsKey(i)) map.put(i,1);
        //     else {
        //         int x = map.get(i);
        //         map.put(i,x+1);
        //     }
        // }
        
        // PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        // int size = map.size();
        // map.forEach((k,v) -> {
        //     Pair<Character,Integer> pair= new Pair<>(k,v);
        //     pq.add(pair);
        // });
        
        // // System.out.print(pq.size()+" ");
        // int ans = 0;
        // while(!pq.isEmpty()) {
        //     int interval = n+1;
        //     int count = 0;
        //     List<Pair<Character,Integer>> store = new ArrayList<>();
        //     while(interval > 0 && !pq.isEmpty()) {
        //         Pair<Character,Integer> pair = pq.poll();
        //         char key = pair.getKey();
        //         int cf = pair.getValue();
        //         if(cf > 1) store.add(new Pair<>(key, cf-1));
        //         count++;
        //         interval--;
        //     }
        //     // System.out.print(map.size()+" ");
        //     for(var i : store) pq.add(i);
        //     ans += (pq.isEmpty()) ? count : (count + interval);
        // }
        // return ans;


        // method 2:
        int ans = 0;
        int[] freq = new int[26];
        for(char ch : tasks) {
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        for(int i : freq) {
            if(i > 0) pq.add(i);
        }

        while(!pq.isEmpty()) {
            int interval = n+1;
            int count = 0;
            List<Integer> store = new ArrayList<>();
            while(interval > 0 && !pq.isEmpty()) {
                int currFreq = pq.poll();
                if(currFreq > 1) store.add(currFreq-1);
                count++;
                interval--;
            }
            for(var i : store) pq.add(i);
            ans += (pq.isEmpty()) ? count : (interval + count);
        }
        return ans;
    }
}