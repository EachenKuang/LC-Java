package com.eachenkuang.suixianglu.linklists;

public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode current = dummyNode;
        while (current.next != null && current.next.next != null) {
            ListNode node1 = current.next;
            ListNode node2 = current.next.next;
            current.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            current = node1;

            // ListNode temp1 = current.next;
            // ListNode temp2 = current.next.next.next;
            // current.next = current.next.next;
            // current.next.next = temp1;
            // temp1.next = temp2;
        }
        return dummyNode.next;
    }
    
}
