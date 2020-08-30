package leetcode;

import java.util.Arrays;

class num36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValid(board, i, i + 1, 0, 9))
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (!isValid(board, 0, 9, i, i + 1))
                return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValid(board, i * 3, (i + 1) * 3, j * 3, (j + 1) * 3))
                    return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int rlow, int rhigh, int clow, int chigh) {
        boolean[] used = new boolean[10];
        for (int i = rlow; i < rhigh; i++) {
            for (int j = clow; j < chigh; j++) {
                if (board[i][j] == '.')
                    continue;
                if (used[board[i][j] - '0'] == true)
                    return false;
                else
                    used[board[i][j] - '0'] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        num36 s = new num36();
        System.out.println(s.isValidSudoku(board));
    }
}