package com.eachenkuang.jingdian;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
你不需要 保留 每个分区中各节点的初始相对位置。
 */
public class Jingdian2_4 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                head1.next = new ListNode(p.val);
                head1 = head1.next;
            } else {
                head2.next = new ListNode(p.val);
                head2 = head2.next;
            }
            p = p.next;
        }
        head1.next = temp2.next;
        return temp1.next;
    }
}
