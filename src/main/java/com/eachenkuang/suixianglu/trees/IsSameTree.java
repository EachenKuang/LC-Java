package com.eachenkuang.suixianglu.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author eachenkuang
 * @date 2022/8/24 10:19 AM
 * @description:
 */
public class IsSameTree {

    /**
     * 递归法
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    public boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q ==null ) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val){
            return false;
        } else {
            return compare(p.left, q.left) && compare(p.right, q.right);
        }
    }

    /**
     * 迭代法比较，使用一个队列来保存两个对应需要比较的节点
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        return check(p, q);
    }

    private boolean check(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q ==null ) {
                continue; // 继续下一轮比较
            } else if (p == null || q == null) {
                return false;
            } else if (p.val != q.val) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.left);
            queue.offer(p.right);
            queue.offer(q.right);
        }
        return true;
    }
}
