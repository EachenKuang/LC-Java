package com.eachenkuang.suixianglu.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/23 3:50 PM
 * @description:
 * 二叉树的层数遍历
 */
public class TreeLevelVisit {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return result;
        }
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = deque.removeLast();
                if (root.left != null) deque.addFirst(root.left);
                if (root.right != null) deque.addFirst(root.right);
                tempList.add(root.val);
            }
            result.add(tempList);
        }
        return result;
    }
}
