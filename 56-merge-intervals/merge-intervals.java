class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> {  
                return a[0]-b[0];
            }
        );
        List<int[]> list = new ArrayList<>();
        int row = intervals.length;

        for(int i = 0; i < row; i++) {
            int[] temp = intervals[i];
            for(int j = i+1; j < row; j++) {
                if(temp[1] < intervals[j][0]) break;
                temp[0] = Math.min(temp[0], intervals[j][0]);
                temp[1] = Math.max(temp[1], intervals[j][1]);
                i++;
            }
            list.add(temp);
        }
        int size = list.size();
        int[][] ans = new int[size][2];
        for(int i = 0; i < size; i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}