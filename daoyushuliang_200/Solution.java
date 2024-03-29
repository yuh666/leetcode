package daoyushuliang_200;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    int[][] d = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    int m, n;
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int c = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid);
                    c++;
                }
            }
        }
        return c;
    }

    private void dfs(int i, int j, char[][] grid) {
        visited[i][j] = true;
        for (int k = 0; k < d.length; k++) {
            int x = i + d[k][0];
            int y = j + d[k][1];
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == '1') {
                dfs(x, y, grid);
            }
        }
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        new Solution().numIslands(chars);
    }


}
