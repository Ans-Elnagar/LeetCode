class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidRows(board) && isValidColumns(board) && isValidSubs(board);
    }
    private boolean isValidRows(char[][] board){
        for(int i=0; i<9; i++){
            boolean[] digits = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[i][j] == '.')
                    continue;
                if(digits[board[i][j] - '1'])
                    return false;
                digits[board[i][j] - '1'] = true;
            }
        }
        return true;
    }
    private boolean isValidColumns(char[][] board){
        for(int i=0; i<9; i++){
            boolean[] digits = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[j][i] == '.')
                    continue;
                if(digits[board[j][i] - '1'])
                    return false;
                digits[board[j][i] - '1'] = true;
            }
        }
        return true;
    }
    private boolean isValidSubs(char[][] board){
        for(int i=0; i<9; i += 3){
            for(int j=0; j<9; j+=3){
                // check this sub starting at i,j
                boolean[] digits = new boolean[9];
                for(int k=i; k<i+3; k++){
                    for(int h=j; h<j+3; h++){
                        if(board[k][h] == '.')
                            continue;
                        if(digits[board[k][h] - '1'])
                            return false;
                        digits[board[k][h] - '1'] = true;
                    }
                }
                
            }
        }
        return true;
    }
}