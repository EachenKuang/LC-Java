package com.eachenkuang.suixianglu.trees;

import java.util.Stack;

public class GetMinimumDifference {
    int result = Integer.MAX_VALUE;
    TreeNode pre;
    /**
     * 递归法，中序遍历
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return result;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        if (pre != null) {
            result = Math.min(result, cur.val - pre.val);
        }
        pre = cur;
        traversal(cur.right);
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public int getMinimumDifference2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        TreeNode pre = null, cur = root; // 记录前驱节点
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;   // 左
            } else {
                cur = stack.pop();
                if (pre != null) {        // 中
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right;    
            }
        }
        return result;
    }
}
