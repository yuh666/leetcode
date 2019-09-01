package erchashudesuoyoulujing_257;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<String> list = new ArrayList<>();
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }
        List<String> left = binaryTreePaths(root.left);
        if (left != null) {
            for (String s : left) {
                list.add(root.val + "->" + s);
            }
        }
        List<String> right = binaryTreePaths(root.right);
        if (right != null) {
            for (String s : right) {
                list.add(root.val + "->" + s);
            }
        }
        return list;
    }
}