package com.eachenkuang.suixianglu.trees;

import java.util.Stack;

/**
 * @author eachenkuang
 * @date 2022/8/24 10:42 AM
 * @description:
 * 这道题目要求左叶子之和，其实是比较绕的，因为不能判断本节点是不是左叶子节点。
 *
 * 此时就要通过节点的父节点来判断其左孩子是不是左叶子了。
 *
 * 平时我们解二叉树的题目时，已经习惯了通过节点的左右孩子判断本节点的属性，而本题我们要通过节点的父节点判断本节点的属性。
 */
public class SumOfLeftLeaves {
    /**
     * 递归法，遍历所有节点，判断是否是满足条件的左子树叶子
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            result += root.left.val;
        }
        return result + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    result += root.left.val;
                } else {
                    stack.push(root.left);
                }
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return result;
    }

}
