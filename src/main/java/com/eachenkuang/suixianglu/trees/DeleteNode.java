package com.eachenkuang.suixianglu.trees;

public class DeleteNode {
    /**
     * 递归
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        return traversal(root, key);
    }

    public TreeNode traversal(TreeNode root, int key) {
        // 第一种情况——没找到节点
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 找到节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode cur = root.right;
            // 找到右子树的最左边的节点（也就是刚刚大于需要删除的节点的值）
            while (cur.left != null) {
                cur = cur.left;
            }
            // 将左子树移动到cur
            cur.left = root.left;
            // 删除节点
            root = root.right; // 返回旧root的右孩子作为新root
            return root;
        } else if (root.val > key) {
            root.left = traversal(root.left, key);
        } else {
            root.right = traversal(root.right, key);
        }
        return root;
        
    }
}
