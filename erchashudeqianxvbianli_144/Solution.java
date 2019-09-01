package erchashudeqianxvbianli_144;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        _preorderTraversal(root,list);
        return list;
    }
    public void _preorderTraversal(TreeNode root,List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        _preorderTraversal(root.left,list);
        _preorderTraversal(root.right,list);
    }
}
