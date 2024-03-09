class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        
        int left = 0, right = m-1;
        int top = 0, bottom = n-1;

        while(true) {
            for(int i = left; i <= right; i++){
                System.out.print(matrix[left][i]+" ");
                ans.add(matrix[left][i]);
            }
            top++;
            if(top > bottom) break;
            
            for(int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right]+" ");
                ans.add(matrix[i][right]);
            }
            right--;
            if(left > right) break;
            
            
            for(int i = right; i >= left; i--) {
                System.out.print(matrix[bottom][i]+" ");
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            if(top > bottom) break;

            for(int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left]+" ");
                ans.add(matrix[i][left]);
            }
            left++;
            if(left > right) break;

        }
        
        return ans;
    }
}