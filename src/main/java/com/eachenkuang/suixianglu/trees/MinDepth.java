package com.eachenkuang.suixianglu.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author eachenkuang
 * @date 2022/8/23 7:10 PM
 * @description:
 * 最小深度
 * 误区：（与最大深度不同的地方）
 * 一定要计算有叶子节点的深度，如果没有叶子节点，只有一边有节点，则深度还是为单边的节点深度
 */
public class MinDepth {
    /**
     * 递归法 区分四种情况
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    /**
     * 迭代法 层序遍历
     * 在找到该层的叶子节点后即可直接返回
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    // 找到叶子节点 既可以返回深度
                    return result;
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


}
