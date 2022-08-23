package com.eachenkuang.suixianglu.trees;

/**
 * @author eachenkuang
 * @date 2022/8/23 8:04 PM
 * @description:
 * 是否是二叉平衡树
 */
public class IsBalanced {

    /**
     * 递归法1
     * 时间复杂度 O(N^2)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }


    /**
     * 递归法2
     * 计算每个节点的深度
     * 自底向上
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return getHeight(root) != -1;
    }

    /**
     *
     * 用 -1 表示 不是平衡二叉树，否则返回其高度
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);
    }
}
