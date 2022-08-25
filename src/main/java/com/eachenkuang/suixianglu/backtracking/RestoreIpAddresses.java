package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/25 3:27 PM
 * @description:
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses {
    List<String> results = new ArrayList<>();
    List<String> paths = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0);
        return results;
    }

    /**
     * 这里有个隐含条件，ip 只有四个数 k = 4
     * @param s
     * @param startIndex
     */
    public void backTracking(String s, int startIndex) {
        if (paths.size() == 4) {
            if (startIndex >= s.length()) {
                results.add(String.join(".", paths)); // 需要预处理IP
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex, i);
            if (isValidAddress(temp)) {
                // 如果切割的子串满足地址要求，加入 paths
                paths.add(temp);
            } else {
                continue;
            }
            backTracking(s, i+1);
            paths.remove(paths.size()-1);
        }
    }

    /**
     * 进一步优化
     * @param s
     * @param startIndex
     */
    public void backTracing2(String s, int startIndex) {
        if (paths.size() == 3) {
            String lastAdd = s.substring(startIndex);
            if (isValidAddress(lastAdd)) {
                paths.add(lastAdd);
                results.add(String.join(".", paths));
                paths.remove(paths.size()-1);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex, i);
            if (isValidAddress(temp)) {
                // 如果切割的子串满足地址要求，加入 paths
                paths.add(temp);
            } else {
                continue;
            }
            backTracing2(s, i+1);
            paths.remove(paths.size()-1);
        }
    }

    /**
     * 判断是否是在 0 到 255之间。
     * @param s
     * @return
     */
    public boolean isValidAddress(String s) {
        // 需要解决0开头的一些异常情况
        // 0X
        // 0XX
        if (s.length() == 0) {
            return false;
        }
        if (s.length() >= 2 && s.charAt(0) == '0') {
            return false;
        }
        if (s.length() > 3) {
            return false;
        }
        int v = Integer.parseInt(s);
        return v >= 0 && v <= 255;
    }
}
