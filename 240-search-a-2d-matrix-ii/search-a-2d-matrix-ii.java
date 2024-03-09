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
        // method 1: T.C. = O(n*log(m))

        int row = matrix.length;
        int col = matrix[0].length;

        // for(int i = 0; i < row; i++) {
        //     if(find(matrix[i], target)) return true;
        // }
        // return false;

        // method 2: T.C. = O(n+m), S.C. = O(1)
        int i = 0, j = col-1;
        while(i < row && j >= 0) {
            if(matrix[i][j] == target) return true;
            if(target > matrix[i][j]) i++;
            else j--;
        }

        return false;
    }
}