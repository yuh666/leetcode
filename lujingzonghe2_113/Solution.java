package lujingzonghe2_113;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if(root.left == null && root.right == null && root.val==sum){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
        }
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        if(left != null){
            for (List<Integer> list : left) {
                list.add(0,root.val);
                lists.add(list);
            }
        }
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        if(right != null){
            for (List<Integer> list : right) {
                list.add(0,root.val);
                lists.add(list);
            }
        }
        return lists;
    }
}
