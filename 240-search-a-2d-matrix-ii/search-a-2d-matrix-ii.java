class Solution {
    boolean find(int[] arr, int k) {
        int i = 0, j = arr.length-1;
        while(i <= j) {
            int mid = (i+j)/2;
            if(arr[mid] == k) return true;
            if(k > arr[mid]) i = mid+1;
            else j = mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        // int col = matrix[0].length;

        for(int i = 0; i < row; i++) {
            if(find(matrix[i], target)) return true;
        }
        return false;

        // int st = 0, end = row*col -1;
        // while(st <= end) {
        //     int mid = st + (end-st)/2;
        //     int i = mid / col;
        //     int j = mid % col;
        //     // System.out.println(i+" "+j);
        //     if(matrix[i][j] == target) return true;
        //     if(target > matrix[i][j]) st = mid+1;
        //     else end = mid-1;
        // }
        // return false;
    }
}