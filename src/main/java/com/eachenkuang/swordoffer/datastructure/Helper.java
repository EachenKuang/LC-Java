package com.eachenkuang.swordoffer.datastructure;

/**
 * 用于生成固定数据结构的帮助类
 * @author eachenkuang
 * @date 2022/1/29 11:34 上午
 * @description:
 */
public class Helper {
    public static ListNode buildListNodeFromArrays(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode h = head;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            h.setNext(node);
            h = h.getNext();
        }
        return head.getNext();
    }

    public static int[] buildArraysFromListNode(ListNode head) {
        ListNode h = head;
        int count = 0;
        while (h != null) {
            h = h.getNext();
            count++;
        }
        h = head;
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = h.getVal();
            h = h.getNext();
        }
        return res;
    }
}
