class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->a[1] - b[1]);
        int n = points.length;
        int cnt = 0;
        int end = 0;
        boolean flag = true;

        for(int i = 0; i < n; i++) {
            end = points[i][1];
            int j = i+1;
            flag = true;
            for(; j < n; j++) {
                if(end >= points[j][0] && end <= points[j][1]) {
                    if(flag) cnt++;
                    flag = false;
                }
                else break;
                
            }
            if(i==j-1) cnt++;
            i = j-1;
        }
        return cnt;
    }
}