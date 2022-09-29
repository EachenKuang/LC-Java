package com.eachenkuang.jingdian;

/**
 * @author eachenkuang
 * @date 2022/1/27 7:12 下午
 * @description:
 */
public class ListNode {

      int val;

      ListNode next;

      public ListNode(int x) { val = x; }

      public int getVal() {
            return val;
      }

      public ListNode getNext() {
            return next;
      }

      public void setVal(int val) {
            this.val = val;
      }

      public void setNext(ListNode next) {
            this.next = next;
      }
}
