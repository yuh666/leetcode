package zuixiaolujinghe_64;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    //状态转移方程
    // F(i,j) = min(F(i-1,j),F(i,j-1))+grid[i][j]
    public int minPathSum(int[][] grid) {
        int[][] state = new int[grid.length][grid[0].length];
        state[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            state[0][i] = state[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            state[i][0] = state[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                state[i][j] = Math.min(state[i][j - 1], state[i - 1][j]) + grid[i][j];
            }
        }
        return state[state.length - 1][state[0].length - 1];
    }
}
