package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class Combine {

    List<List<Integer>> results = new ArrayList<>();
    Deque<Integer> paths = new LinkedList<>();

    /**
     * 回溯法
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        backtracing(1, n, k);
        return results;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex
     * @param n
     * @param k
     */
    public void backtracing(int startIndex, int n, int k) {
        if (paths.size() == k) {
            // 把结果加入
            results.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            paths.add(i);
            backtracing(i+1, n, k);
            paths.removeLast();
        }
    }

    /**
     * 进行了剪枝优化的回溯,
     * 已经选择的元素个数：path.size();
     * 还需要的元素个数为: k - path.size();
     * 在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
     * 为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
     * 举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。
     * 从2开始搜索都是合理的，可以是组合[2, 3, 4]。
     * @param startIndex
     * @param n
     * @param k
     */
    public void backtracing2(int startIndex, int n, int k) {
        if (paths.size() == k) {
            // 把结果加入
            results.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i <= n - (k - paths.size()) + 1; i++) {
            paths.add(i);
            backtracing(i+1, n, k);
            paths.removeLast();
        }
    }
}
