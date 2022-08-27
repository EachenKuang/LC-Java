package com.eachenkuang.suixianglu.trees;

public class ConvertBST {

    int pre = 0;
    /**
     * 递归  右 中 左
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += pre;
        pre = root.val;
        convertBST(root.left);
        return root;
    }
}
