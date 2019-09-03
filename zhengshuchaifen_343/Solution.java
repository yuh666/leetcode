package zhengshuchaifen_343;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


//    Map<Integer,Integer> map = new HashMap<>();
//    public int integerBreak(int n) {
//        if(n == 1){
//            return 1;
//        }
//        Integer val = map.get(n);
//        if (val != null){
//            return val;
//        }
//        int res = 0;
//        for (int i = 1; i < n; i++) {
//            res = max(res,i*(n-i),i*integerBreak(n-i));
//        }
//        map.put(n,res);
//        return res;
//    }


    public int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                arr[i] = max(arr[i], j * (i - j), j * arr[i - j]);
            }
        }
        return arr[n];
    }

    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
