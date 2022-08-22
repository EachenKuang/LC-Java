package com.eachenkuang.suixianglu.twopoint;

import com.eachenkuang.suixianglu.linklists.ListNode;

public class RemoveNthFromEnd {

    /**
     * 使用双指针法
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode fast = dummyNode, slow = dummyNode;
        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
    
}
