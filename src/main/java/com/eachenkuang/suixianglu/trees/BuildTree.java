package com.eachenkuang.suixianglu.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eachenkuang
 * @date 2022/8/24 3:07 PM
 * @description:
 *
 *
 */
public class BuildTree {

    // 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
    Map<Integer, Integer> map;  // 方便根据数值查找位置
    /**
     * 使用递归
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }
        return traversal(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    public TreeNode traversal(int[] inorder, int[] postorder, int inorderBegin, int inorderEnd, int postorderBegin, int postorderEnd) {
        if (inorderEnd - inorderBegin == 0) {
            return null;
        }
        int val = postorder[postorderEnd-1];
        TreeNode root = new TreeNode(val);
        // 找到中序中的切割点
        int splitInorderIndex = map.get(val);
        int splitPostorderIndex = splitInorderIndex - inorderBegin + postorderBegin;
        root.left = traversal(inorder, postorder, inorderBegin, splitInorderIndex, postorderBegin, splitPostorderIndex);
        root.right = traversal(inorder, postorder, splitInorderIndex + 1, inorderEnd, splitPostorderIndex, postorderEnd - 1);
        return root;
    }
}
