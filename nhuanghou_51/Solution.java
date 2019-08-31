package nhuanghou_51;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;
    int[] res;
    List<List<String>> lists = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n + 1];
        dia2 = new boolean[2 * n + 1];
        res = new int[n];
        _solveNQueens(0, n);
        return lists;
    }

    private void _solveNQueens(int i, int n) {
        if(i == n){
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    if(res[j] == k){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            lists.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if(!col[j] && !dia1[i+j] && !dia2[i-j+n-1]){
                res[i] = j;
                col[j] = true;
                dia1[i+j] = true;
                dia2[i-j+n-1] = true;
                _solveNQueens(i+1,n);
                col[j] = false;
                dia1[i+j] = false;
                dia2[i-j+n-1] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("=========");
        }
    }
}
