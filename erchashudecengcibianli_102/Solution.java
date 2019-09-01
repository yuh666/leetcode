package erchashudecengcibianli_102;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<LevelNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
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
        return list;
    }

    class LevelNode {
        int level;
        TreeNode val;

        public LevelNode(int level, TreeNode val) {
            this.level = level;
            this.val = val;
        }
    }
}
