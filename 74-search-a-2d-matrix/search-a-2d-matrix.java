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

        for(int i = 0; i < row; i++) {
            if(find(matrix[i], target)) return true;
        }
        return false;
    }
}