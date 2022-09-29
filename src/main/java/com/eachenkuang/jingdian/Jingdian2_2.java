package com.eachenkuang.jingdian;

public class Jingdian2_2 {
    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return -1;
        }
        ListNode fast = head;
        ListNode low = head;
        int i = 0;
        while (i < k && fast != null) {
            fast = fast.next;
            i++;
        }
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        return low.val;
    }
}
