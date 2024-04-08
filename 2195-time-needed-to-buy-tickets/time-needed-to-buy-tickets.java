class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int cnt = 0;
        while(tickets[k] > 0) {
            for(int i = 0; i < n; i++) {
                if(tickets[i] > 0) {
                    tickets[i]--;
                    cnt++;
                }
                if(tickets[k] == 0) return cnt;
            }
        }

        return cnt;
    }
}