class Solution {

    int n; int m; 
    boolean isvaild(int x, int y){
        if(x<0 || x >= n || y<0 || y>= m)
            return false; 

        return true; 
    }
    int[] arr ={0,0,1,-1}; 
    int[] arr1 = {1,-1,0,0}; 

    boolean ans = false; 

    void dfs(char[][] board, int crr_x, int crr_y, String word, int k, int[][] visit) {
        
        if(ans) return; 

        visit[crr_x][crr_y]=1;  

        if(k==word.length()){
            ans = true; 
            return; 
        }
        // System.out.print(crr_x+" "+crr_y); 
        for(int i=0; i<4; i++){
            int x = crr_x + arr[i]; 
            int y = crr_y + arr1[i]; 
            // System.out.print(x+" "+y); 
            if(isvaild(x,y) && visit[x][y]!=1 && word.charAt(k)==board[x][y]){ 
                    // System.out.print(x+" "+y); 
                    dfs(board,x,y,word,k+1,visit); 
            }
        } 
       visit[crr_x][crr_y]=0; 
    }
    public boolean exist(char[][] board, String word) {
         n = board.length;
         m = board[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(word.charAt(0) == board[i][j]) {
                    int[][] visit = new int[n][m];
                    dfs(board, i, j, word, 1, visit);
                    if(ans) return true; 
                }
            }

        }
        return ans; 
    }
}