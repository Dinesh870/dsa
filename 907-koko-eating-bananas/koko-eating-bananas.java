class Solution {
    int totalHours(int[] piles, int speed) {
        int totalHours = 0;
        for(int i : piles) totalHours += Math.ceil(i/(speed+0.0));
        return totalHours;
    }
    int findMax(int[] piles) {
        int max = 0;
        for(int i : piles) max = Math.max(i, max);
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        // int j = 1;
        // while(j < Integer.MAX_VALUE) {
        //     long totalHours = 0;
        //     for(int i = 0; i < n; i++) {
        //         // System.out.print(piles[i]/j + " ");
        //         if(piles[i] % j == 0) totalHours += (piles[i] / j);
        //         else totalHours += (piles[i] / j + 1);

        //         if(totalHours == h && i == n-1) return j;
        //     }
        //     // if(totalHours <= h) continue; 
        //     // System.out.print(totalHours+" ");
            
        //     // ans = Math.min(ans,j);
        //     if(totalHours <= h) return j;
        //     j++;
        // }
        // return 1;

        int st = 1, end = findMax(piles);
        int ans = 0;

        while(st <= end) {
            int mid = st + (end-st)/2;

            int toHours = totalHours(piles, mid);
            
            if(toHours <= h) {
                ans = mid;
                end = mid-1;
            }else {
                st = mid+1;
            }

        }
        return ans;
    }
}