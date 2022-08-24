package com.eachenkuang.suixianglu.trees;

import java.util.List;
import java.util.Stack;

/**
 * @author eachenkuang
 * @date 2022/8/24 7:46 PM
 * @description:
 */
public class IsValidBST {
    /**
     * 左中右 中序遍历出所有数，然后比较相邻是否单调递增，即可。
     * 如果有不符合，就返回
     *
     * @param root
     * @return
     */

    long maxVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return traversal(root);
    }

    public boolean traversal(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = traversal(root.left);
        // 处理节点逻辑
        if (root.val <= maxVal) {
            return false;
        }
        maxVal = root.val;
        boolean right = traversal(root.right);
        return left && right;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;// 左
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;
            root = pop.right;// 右
        }
        return true;
    }
}
