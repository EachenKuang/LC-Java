package com.eachenkuang.swordoffer;

import com.eachenkuang.swordoffer.datastructure.TreeNode;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 * @author eachenkuang
 * @date 2022/1/29 2:11 下午
 * @description:
 */
public class Sword07 {
    /**
     * 使用递归方法
     * 先确定根节点，然后确定左节点与右节点，对于每个节点，继续递归
     * @param preorder
     * @param inorder
     * @return
     */
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }                    // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }


}
