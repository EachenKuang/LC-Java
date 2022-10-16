package com.eachenkuang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/10/10 09:33
 * @description:
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class Lc118 {


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    public static List<List<Integer>> generate2(int numRows) {
        if (numRows < 1) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        result.add(one);
        if (numRows == 1) {
            return result;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = result.get(i-1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 0; j < pre.size()-1; j++) {
                current.add(pre.get(j)+ pre.get(j+1));
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows = 4;
        System.out.println(generate(numRows));
    }
}
