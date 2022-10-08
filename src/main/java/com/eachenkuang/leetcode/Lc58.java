package com.eachenkuang.leetcode;

import com.eachenkuang.arrays.Solution;

/**
 * @author eachenkuang
 * @date 2022/10/8 15:22
 * @description:
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 *
 */
public class Lc58 {

    /**
     * 使用库函数 split
     * 在刷题过程中，可以使用，但是面试过程中不太推荐哈
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }

    /**
     * 从后往前遍历
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
}
