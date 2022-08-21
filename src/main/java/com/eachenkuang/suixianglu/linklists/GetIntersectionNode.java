package com.eachenkuang.suixianglu.linklists;

public class GetIntersectionNode {

    /**
     *  交叉法
        AAA  BB
        AAABB
        BBAAA
        这样两个链表的长度就一致了，那么如果，两个链表有交叉，那么最后一定有交叉，循环会终止在第一个节点
        如果两个链表没有交叉，那么最后循环会终止在最后一个None上。
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            if (tempA == null) {
                tempA = headB;
            } else {
                tempA = tempA.next;
            }
            if (tempB == null) {
                tempB = headA;
            } else {
                tempB = tempB.next;
            }
        }
        return tempA;
    }

    /**
     * 还可以先计算出两个链表的长度，然后计算差d
     * 从长的链表，先走d步，然后比较每个节点是否一致
     * 
     * 
     * 
     * 
     */
    
}
