package fengelianbiao_86;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode higher  = new ListNode(0);
        ListNode higherCurr  = higher;

        ListNode lower  = new ListNode(0);
        ListNode lowerCurr = lower;

        while(head != null){
            ListNode next = head.next;
            if(head.val < x){
                lowerCurr.next = head;
                lowerCurr = lowerCurr.next;
            }else {
                higherCurr.next = head;
                higherCurr = higherCurr.next;
            }
            head.next = null;
            head = next;
        }
        lowerCurr.next = higher.next;
        return lower.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        long l = System.currentTimeMillis();
        ListNode partition = new Solution().partition(node1, 3);
        System.out.println(System.currentTimeMillis()-l);
    }

}
