package com.eachenkuang.leetcode;

import com.eachenkuang.arrays.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/10/21 09:13
 * @description:
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 例如，下面的二进制手表读取 "3:25" 。
 *
 *
 * 链接：https://leetcode.cn/problems/binary-watch
 */
public class Lc401 {
    /**
     *
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }

    /**
     * 另一种枚举方法是枚举所有 2^{10}=10242
     *
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatch2(int turnedOn) {
        // 1 个：1，2，4，8
        // 2 个：3，5，6，9，10，12
        // 3 个：7，11，
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6, m = i & 63; // 用位运算取出高 4 位和低 6 位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }
}
