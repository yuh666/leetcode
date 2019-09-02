package hezhishaoweikdezuiduanzishuzu_862;

import java.util.Arrays;

/**
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * <p>
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    public int shortestSubarray(int[] A, int K) {
        if (A.length == 0) {
            return 0;
        }
        int minLen = A.length + 1;
        int l = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum >= K) {
                minLen = Math.min(minLen, i - l + 1);
                while (l < i && sum - A[l] >= K) {
                    sum -= A[l];
                    l++;
                    minLen = Math.min(minLen, i - l + 1);
                }
            }
        }
        return minLen == A.length + 1 ? -1 : minLen;
    }


    public static void main(String[] args) {
        int[] A = {84,-37,32,40,95};
        int i = new Solution().shortestSubarray(A, 167);
        System.out.println(i);
    }
}
