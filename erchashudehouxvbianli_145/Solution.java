package erchashudehouxvbianli_145;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        _postorderTraversal(root, list);
        return list;
    }

    public void _postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        _postorderTraversal(root.left, list);
        _postorderTraversal(root.right, list);
        list.add(root.val);
    }
}