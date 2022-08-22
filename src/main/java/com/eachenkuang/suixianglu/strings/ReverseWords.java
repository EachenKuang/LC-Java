package com.eachenkuang.suixianglu.strings;

import com.eachenkuang.arrays.Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/22 2:17 PM
 * @description:
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {

    /**
     * 使用库函数
     *
     * 不推荐
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     * 1. 先解决多余的空格
     * 2. 整体翻转
     * 3. 对每个单词进行翻转
     *
     * 需要考虑删除多余的空格，前面的空格，末尾的空格，以及中间的空格，只保留一个
     * 难点在于删除空格
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // 先移除多余的空格
        StringBuilder sb = removeExtraSpaces(s);
        // 翻转整个字符串
        reverseString(sb, 0, sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }

    /**
     * 翻转字符串
     * @param sb
     * @param i
     * @param j
     */
    private static void reverseString(StringBuilder sb, int i, int j) {
        while (i < j && i >= 0 && j < sb.length()) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
    }

    /**
     * 翻转各个单词
     * @param sb
     */
    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    /**
     * 移除多余的空格
     * @param s
     * @return
     */
    private StringBuilder removeExtraSpaces(String s) {
        int start = 0;
        int end = s.length() - 1;
        // 去除首位的空格
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            // 只能存在一个空格
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.print(reverseWords.reverseWords(" how old are   you "));
    }
}
