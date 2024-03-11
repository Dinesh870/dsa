class Solution {
    int search(int[][] score, int target, int k) {
        for(int i = 0; i < score.length; i++) {
            if(score[i][k] == target) return i;
        }
        return -1;
    }
    void swap(int[][] score, int i, int j) {
        int col = score[0].length;
        for(int k = 0; k < col; k++) {
            int temp = score[i][k];
            score[i][k] = score[j][k];
            score[j][k] = temp;
        }
    }
    public int[][] sortTheStudents(int[][] score, int k) {
        // int m = score.length;
        // int n = score[0].length;
        // int[] temp = new int[m];
        // for(int i = 0; i < m; i++) {
        //     temp[i] = score[i][k];
        // }

        // Arrays.sort(temp);

        // for(int i = 0; i < m; i++) {
        //     int idx = search(score, temp[m-i-1], k);
        //     if(i != idx) {
        //         swap(score, i, idx);
        //     }
        // }
        // return score;

        Arrays.sort(score, (a,b) -> b[k] - a[k]);
        return score;
    }
}