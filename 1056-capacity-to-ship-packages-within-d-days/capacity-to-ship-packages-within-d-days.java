class Solution {

    // method 1:
    // int fun(int[] weights, int cnt) {
    //     int minCapacity = 0, maxCapacity = 0;
    //     for(int i : weights) {
    //         minCapacity = Math.max(minCapacity, i);
    //         maxCapacity += i;
    //     }

    //    while(minCapacity <= maxCapacity) {
    //          int sum = 0;
    //          int days = cnt;

    //         for(int i : weights) {
                
    //             if(sum + i > minCapacity) {
    //                 days--;
    //                 sum = i;
    //             } else {
    //                 sum += i;
    //             }

    //         }
    //         System.out.print(days+" ");
    //         if(days > 0) return minCapacity;
    //         minCapacity++;

    //    }
    //    return 0;
    // }

    // method 2: Binary search
    int binarySearch(int[] weights, int cnt) {

        int minCapacity = 0, maxCapacity = 0;
        for(int i : weights) {
            minCapacity = Math.max(minCapacity, i);
            maxCapacity += i;
        }

        int ans = 0;
        while(minCapacity <= maxCapacity) {

            int capacity = minCapacity + (maxCapacity-minCapacity)/2;
            int sum = 0, days = cnt;

            for(int i : weights) {
                
                if(sum + i > capacity) {
                    days--;
                    sum = i;
                } else {
                    sum += i;
                }

                if(days <= 0) break;
            }

            if(days > 0) {
                ans = capacity;
                maxCapacity = capacity-1;
            }else minCapacity = capacity+1;

        }
        return ans;

    }

    public int shipWithinDays(int[] weights, int days) {
        
        // return fun(weights, days);

        return binarySearch(weights, days);
        
    }
}