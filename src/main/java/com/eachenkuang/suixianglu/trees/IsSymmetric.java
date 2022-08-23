package com.eachenkuang.suixianglu.trees;

import com.eachenkuang.arrays.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author eachenkuang
 * @date 2022/8/23 4:50 PM
 * @description:
 */
public class IsSymmetric {
    /**
     * 递归法
     * @param root
     * @return
     * 先判断 root 是否为 null，如果是，则为对称。
     * 然后比较两个子树，左子树是否是右子树的对称树，这里使用 compare 函数
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    /**
     * 比较函数，用于递归使用比较下层的子树
     * @param left
     * @param right
     * @return
     *
     * 这里使用递归方法，首先两个子树都为空，则对称
     * 两个子树其中一个为空，则不对称
     * 两个子树都不为空，比较节点值是否相同
     * 值相同，则继续比较下一步，左子树的左子树与右子树的右子树进行比较；左子树的右子树与右子树的左子树进行比较。
     * 递归调用 compare 即可。
     */
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            // 两个都为空
            return true;
        } else if (left == null || right == null) {
            // 只有一个为空
            return false;
        } else if (left.val != right.val) {
            // 两个值不同
            return false;
        } else {
            return compare(left.left, right.right) && compare(left.right, right.left);
        }
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);

    }

    /**
     * 这里使用队列来保存需要比较的两个节点
     * 每次提取两个结点并比较它们的值（队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像），然后将两个结点的左右子结点按相反的顺序插入队列中。
     * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     *
     * 事实上，使用栈也是可以的。不同的是，使用队列的方式，是BFS（层序遍历），使用栈的话，是DFS的方式（前序遍历）
     * @param u
     * @param v
     * @return
     */
    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                // 循环的一个结束条件
                return false;
            }

            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }

}
