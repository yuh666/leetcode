package fanzhuanlianbiao_92;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        for (int i = 0; i < m - 1; i++) {
            curr = curr.next;
        }
        curr.next = reverseList(curr.next, n - m + 1);
        return dummy.next;
    }

    public ListNode reverseList(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode newHead = null;
        while (n > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            n--;
        }
        first.next = head;
        return newHead;
    }

}