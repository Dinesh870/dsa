class Solution {
    
    boolean dfs(char[][] board, int i, int j, String word, int k, int[][] visit) {

        if(k >= word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(visit[i][j] == 1) return false;

        // go right
        if(board[i][j] == word.charAt(k)) {                                                                                                                                      
            visit[i][j] = 1;
            k++;
        } else {
            // visit[i][j] = 1;
            return false;
        }    
        
        boolean right = dfs(board, i, j+1, word, k, visit);

        boolean left = dfs(board, i, j-1, word, k, visit);
        boolean bottom = dfs(board, i+1, j, word, k, visit);
        boolean up = dfs(board, i-1, j, word, k, visit);

         visit[i][j] = 0;
        return right || bottom || up || left;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        if(m*n < word.length()) return false;
        int[][] visit = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(dfs(board, i, j, word, 0, visit)) return true;
                }
            }

        }
        return false;
    }
}