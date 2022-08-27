package com.eachenkuang.suixianglu.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class FindModeInBST {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    /**
     * 递归法——暴力法
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        traversal(root);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
        .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
        .collect(Collectors.toList());
        list.add(mapList.get(0).getKey());
        // 把频率最高的加入 list
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                list.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        traversal(root.left);
        traversal(root.right);
    }


    int count = 0;
    int maxCount = 0;
    TreeNode pre = null;
    List<Integer> modeList = new ArrayList<>();

    /**
     * 递归法，中序遍历
     * @param root
     * @return
     */
    public int[] findMode2(TreeNode root) {
        traversal2(root);
        return modeList.stream().mapToInt(Integer::intValue).toArray();
    }

    public void traversal2(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal2(root.left);
        // 处理逻辑
        int rootValue = root.val;
        // 计数
        if (pre == null || rootValue != pre.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新结果以及maxCount
        if (count > maxCount) {
            modeList.clear();
            modeList.add(rootValue);
            maxCount = count;
        } else if (count == maxCount) {
            modeList.add(rootValue);
        }
        pre = root;

        traversal2(root.right);
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public int[] findMode3(TreeNode root) {
        int count = 0;
        int maxCount = 0;
        TreeNode pre = null, cur = root;
        List<Integer> modeList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // 准备计数
                if (pre == null || pre.val != cur.val) {
                    count = 1;
                } else {
                    count++;
                }
                // 更新结果 count
                if (count > maxCount) {
                    maxCount = count;
                    modeList.clear();
                    modeList.add(cur.val);
                } else if (count == maxCount){
                    modeList.add(cur.val);
                }
                // 
                pre = cur;
                cur = cur.right;
            }
        }
        return modeList.stream().mapToInt(Integer::intValue).toArray();
    }
}
