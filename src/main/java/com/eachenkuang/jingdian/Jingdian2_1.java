package com.eachenkuang.jingdian;

import java.util.HashSet;
import java.util.Set;


public class Jingdian2_1 {
    /**
     * 
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        // 考察在链表中删除节点，以及对于HashMap的考察
        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }
}