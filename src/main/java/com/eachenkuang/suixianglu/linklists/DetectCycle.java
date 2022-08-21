package com.eachenkuang.suixianglu.linklists;

public class DetectCycle {

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 存在圈
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
            }
        }
        return null;
    }
    
}
