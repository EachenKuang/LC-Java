package com.eachenkuang.suixianglu.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author eachenkuang
 * @date 2022/8/24 9:35 AM
 * @description:
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class BinaryTreePaths {
    /**
     * 回溯法1,可以看到完整的细节
     * huisu
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> results = new LinkedList<>();
        LinkedList<Integer> paths = new LinkedList<>();
        backTracing(root, results, paths);
        return results;
    }

    public void backTracing(TreeNode root, List<String> results, LinkedList<Integer> paths) {
        paths.addLast(root.val);
        if (root.left == null && root.right == null) {
            // 遇到叶子节点
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            results.add(sb.toString());
            return;
        }
        if (root.left != null) {
            backTracing(root.left, results, paths);
            paths.removeLast(); // 回溯
        }
        if (root.right != null) {
            backTracing(root.right, results, paths);
            paths.removeLast(); // 回溯
        }
    }


    /**
     * 回溯法2,隐藏完整细节
     * 大家应该可以感受出来，如果把 path + "->"作为函数参数就是可以的，因为并有没有改变path的数值，执行完递归函数之后，path依然是之前的数值（相当于回溯了）
     *
     * 综合以上，第二种递归的代码虽然精简但把很多重要的点隐藏在了代码细节里，第一种递归写法虽然代码多一些，但是把每一个逻辑处理都完整的展现了出来了。
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> results = new LinkedList<>();
        String path = "";
        backTracing2(root, results, path);
        return results;
    }

    public void backTracing2(TreeNode root, List<String> results, String path) {
        path += root.val;
        if (root.left == null && root.right == null) {
            // 遇到叶子节点
            results.add(path);
            return;
        }
        if (root.left != null) {
            backTracing2(root.left, results, path+"->");
        }
        if (root.right != null) {
            backTracing2(root.right, results, path+"->");
        }
    }

    /**
     * 迭代法
     */
    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Object> stack = new Stack<>(); // 也可以使用两个栈来表示
        // 节点和路径同时入栈
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            // 节点和路径同时出栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            //左子节点不为空
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return result;
    }
}
