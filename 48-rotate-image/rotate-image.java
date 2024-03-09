class Solution {
    
    public void rotate(int[][] mat) {
        int n = mat.length;
        // method 1: T.C. = O(3*N^2) , S.C. = (N^2);
        // int[][] ans = new int[n][n];

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         ans[i][j] = mat[j][i];
        //     }
        // }

    
        
        // for(int i = 0; i < n; i++) {
        //     int s =0, e = n-1; 
        //     while(s<e){
        //         int t = ans[i][s]; 
        //         ans[i][s]=ans[i][e]; 
        //         ans[i][e] = t;
        //         s++; e--; 
        //     }
        // }
        // for(int i = 0; i < n; i++) {
        //     for(int j =0; j < n; j++) {
        //         mat[i][j] = ans[i][j];
        //     }
        // }

    

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }


        for(int i = 0; i < n; i++) {
            int s = 0, e = n-1;
            while(s < e) {
                int t = mat[i][s];
                mat[i][s] = mat[i][e];
                mat[i][e] = t;
                s++;
                e--;
            }
        }

    }
}