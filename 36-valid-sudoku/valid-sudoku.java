class Solution {
    boolean checkRow(char[] arr) {
        int[] temp = new int[10];
        for(int i = 0; i < 9; i++) {

            if(arr[i] == '.') continue;
            int x = arr[i]-'0';
            if(temp[x] > 0) return false;
            temp[x] = 1;

        }
        return true;
    }

    boolean checkMatrix(char[][] board, int i, int j) {
        int[] temp = new int[10];
        
        for(int row = i; row < i+3; row++) {
            for(int col = j; col < j+3; col++) {

                if(board[row][col] == '.') continue;
                int x = board[row][col] - '0';
                if(temp[x] > 0) return false;
                temp[x] = 1;

            }
        }
        return true;
    }

    boolean checkColumn(char[][] board) {
        for(int i = 0; i < 9; i++) {
            int[] temp = new int[10];

            for(int j = 0; j < 9; j++) {

                if(board[j][i] == '.') continue;
                int x = board[j][i] - '0';
                if(temp[x] > 0) return false;
                temp[x] = 1;

            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        // checking row wise
        for(char[] ch : board) {
            if(!checkRow(ch)) return false;
        }

        // checking column wise
        if(!checkColumn(board)) return false;

        // checking sub-boxes wise
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                if(!checkMatrix(board,i,j)) return false;
            }
        }
        



        return true;
    }
}