package zuhe_77;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        _combine(n, k, 1, new ArrayList<>());
        return lists;
    }

    private void _combine(int n, int k, int index, ArrayList<Integer> list) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            _combine(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution().combine(4, 2);
        System.out.println(combine);
    }
}
