package com.eachenkuang.swordoffer.sw1;

import com.eachenkuang.swordoffer.datastructure.ListNode;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 * @author eachenkuang
 * @date 2022/1/27 7:04 下午
 * @description:
 */
public class Sword06 {
    /**
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode h = head;
        while (h != null) {
            h = h.getNext();
            count++;
        }
        h = head;
        int[] res = new int[count];
        for(int i = count-1; i>=0; i--){
            res[i] = h.getVal();
            h = h.getNext();
        }
        return res;
    }
}
