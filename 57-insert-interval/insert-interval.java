class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        
        // adding non-overlapping intervals
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        // finding all overlapping intervals
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // append the all overlapping intervals
        list.add(newInterval);

        // append the rest intervals which is not overlapping 
        while(i < n) {
            list.add(intervals[i]);
            i++;
        }

        // copying the intervals in 2D array
        int size = list.size();
        int[][] ans = new int[size][2];
        for(i = 0; i < size; i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}