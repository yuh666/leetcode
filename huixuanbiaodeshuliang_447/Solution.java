package huixuanbiaodeshuliang_447;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                map.merge(distance(points[i], points[j]), 1, (o, v) -> o + v);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2) {
                    sum += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }
        return sum;
    }

    public int distance(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0])
                + (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}
