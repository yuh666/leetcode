package qiugendaoyezijiediandeshuzizhihe_129;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 * <p>
 * 输入: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
       List<String> list =  _sumNumbers(root);
       int sum = 0;
       for (int i = 0; i < list.size(); i++) {
            sum += Integer.parseInt(list.get(i));
        }
        return sum;
    }

    private List<String> _sumNumbers(TreeNode root) {
        if(root == null){
            return null;
        }
        List<String> list = new ArrayList<>();
        if(root.left == null && root.right == null){
            list.add(root.val+"");
            return list;
        }

        List<String> left = _sumNumbers(root.left);
        if(left != null){
            for (String s : left) {
                list.add(root.val+""+s);
            }
        }
        List<String> right = _sumNumbers(root.right);
        if(right != null){
            for (String s : right) {
                list.add(root.val+""+s);
            }
        }
        return list;
    }


}
