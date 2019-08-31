package sancisousuo_79;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    int m, n;
    boolean[][] visited;
    int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (_exist(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean _exist(char[][] board, int i, int j, int index, String word) {
        if (index == word.length() - 1) {
            return word.charAt(index) == board[i][j];
        }
        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            for (int k = 0; k < d.length; k++) {
                int x = i + d[k][0];
                int y = j + d[k][1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && _exist(board, x, y, index + 1, word)) {
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
}
