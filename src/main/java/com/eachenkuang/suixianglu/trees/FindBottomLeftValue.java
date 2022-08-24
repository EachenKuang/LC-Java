package com.eachenkuang.suixianglu.trees;

import com.eachenkuang.arrays.Solution;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author eachenkuang
 * @date 2022/8/24 11:03 AM
 * @description:
 */
public class FindBottomLeftValue {

    private int Deep = -1;
    private int value = 0;

    /**
     * 递归法 需要用到全局变脸 Deep 与 value
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue (TreeNode root,int deep) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) {
            findLeftValue(root.left,deep + 1);
        }
        if (root.right != null) {
            findLeftValue(root.right,deep + 1);
        }
    }


    /**
     * 层序遍历 常规方法
     * @param root
     * @return
     */
    public int findBottomLeftValue2(TreeNode root) {
        int result = -1;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (i == 0) {
                    result = temp.val; // 更新成最新一层中的首个数
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return result;
    }

    /**
     * 也是层序遍历，只不过，每一层，从右往左遍历，那么最后一个数一定是最下层左边的数
     * @param root
     * @return
     */
    public int findBottomLeftValue3(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.right != null) {
                queue.offer(p.right);
            }
            if (p.left != null) {
                queue.offer(p.left);
            }
            ret = p.val;
        }
        return ret;
    }

}
