package com.eachenkuang.suixianglu.trees;

/**
 * @author eachenkuang
 * @date 2022/8/23 12:40 PM
 * @description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 完全二叉树生成，使用-1代替空
     * @param nums
     * @return
     */
//    public static TreeNode fromArray(int[] nums) {
//        for (int num: nums) {
//
//        }
//    }
}
