package com.eachenkuang.suixianglu.trees;

/**
 * @author eachenkuang
 * @date 2022/8/24 7:38 PM
 * @description:
 */
public class SearchBST {
    /**
     * 迭代法，因为二叉搜索树是严格排序的，左子树值一定小于根节点，根节点一定大于右子树
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            } else if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    /**
     * 递归法
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return searchBST2(root.val > val ? root.left : root.right, val);
    }

}
