package com.eachenkuang.suixianglu.linklists;

public class RemoveElements {

    /**
     * 添加虚拟节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(Integer.MAX_VALUE, head);
        ListNode point = dummyNode;
        while (point.next != null) {
            if (point.next.val == val) {
                // 需要移除
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }
        return dummyNode.next;

    }

    public static void main(String[] args) {
        
    }
    
}
