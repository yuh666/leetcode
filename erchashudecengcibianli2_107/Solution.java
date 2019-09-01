package erchashudecengcibianli2_107;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    class LevelNode {
        int level;
        TreeNode val;

        public LevelNode(int level, TreeNode val) {
            this.level = level;
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<LevelNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.addLast(new LevelNode(0, root));
        int currlevel = -1;
        while (!queue.isEmpty()) {
            LevelNode levelNode = queue.removeFirst();
            if (levelNode.level > currlevel) {
                list.add(new ArrayList<>());
                currlevel = levelNode.level;
            }
            list.get(currlevel).add(levelNode.val.val);
            TreeNode val = levelNode.val;
            if (val.left != null) {
                queue.addLast(new LevelNode(currlevel + 1, val.left));
            }
            if (val.right != null) {
                queue.addLast(new LevelNode(currlevel + 1, val.right));
            }
        }
        List<List<Integer>> list1 = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            list1.add(list.get(i));
        }
        return list1;
    }
}