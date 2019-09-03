package wanquanpingfangshu_279;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    int[] arr;

//    public int numSquares(int n) {
//        arr = new int[n + 1];
//        return _numSquares(n);
//    }

    private int _numSquares(int n) {
        int val = (int) Math.sqrt(n);
        if (arr[n] != 0) {
            return arr[n];
        }
        if (val * val == n) {
            arr[n] = 1;
            return 1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; n - i * i > 0; i++) {
            res = Math.min(res, _numSquares(n - i * i) + 1);
        }
        arr[n] = res;
        return res;
    }

    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return 1;
        }
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int sqrt1 = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                arr[i] = 1;
            } else {
                arr[i] = i;
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; i > j * j; j++) {
                arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
            }
        }
        return arr[n];
    }


}
