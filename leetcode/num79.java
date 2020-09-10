package leetcode;

class num79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = searchNext(board, word, i, j, 0);
                    if (result)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean searchNext(char[][] board, String word, int i, int j, int index) {
        if (index == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length)
            return false;
        if (board[i][j] != word.charAt(index))
            return false;
        boolean result;
        board[i][j] += 60; // 已搜索标记
        result = searchNext(board, word, i + 1, j, index + 1) || searchNext(board, word, i, j + 1, index + 1)
                || searchNext(board, word, i - 1, j, index + 1) || searchNext(board, word, i, j - 1, index + 1);
        board[i][j] -= 60;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCE";
        num79 s = new num79();
        boolean result = s.exist(board, word);
        System.out.println(result);
    }
}