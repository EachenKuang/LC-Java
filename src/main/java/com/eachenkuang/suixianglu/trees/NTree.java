package com.eachenkuang.suixianglu.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author eachenkuang
 * @date 2022/8/23 4:22 PM
 * @description:
 * 多叉树
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NTree {
    /**
     * 递归法
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        preorderHelper(root, results);
        return results;
    }

    public void preorderHelper(Node root, List<Integer> results) {
        if (root == null) {
            return;
        }
        results.add(root.val);
        if (root.children != null && root.children.size() != 0) {
            for (int i = 0; i < root.children.size(); i++) {
                preorderHelper(root.children.get(i), results);
            }
        }
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            results.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                for (int i = node.children.size()-1; i >= 0; i--) {
                    // 这里需要反过来push，先进后出
                    stack.push(node.children.get(i));
                }
            }
        }
        return results;
    }
}
