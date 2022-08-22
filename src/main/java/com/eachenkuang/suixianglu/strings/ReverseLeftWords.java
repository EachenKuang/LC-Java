package com.eachenkuang.suixianglu.strings;

/**
 * @author eachenkuang
 * @date 2022/8/22 3:01 PM
 * @description:
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * 限制：
 * 1 <= k < s.length <= 10000
 */
public class ReverseLeftWords {
    /**
     * 先全部翻转
     * 然后对分界点 n-k 两部分分别翻转
     *
     * 关于Java，因为在Java中字符串是不可变的，需要还是需要O(N)的空间
     * @param s
     * @param k
     * @return
     */
    public String reverseLeftWords(String s, int k) {
        char[] charArray = s.toCharArray();
        reverseString(charArray, 0, charArray.length-1);
        reverseString(charArray, 0, charArray.length-1-k);
        reverseString(charArray, charArray.length-k, charArray.length-1);
        return new String(charArray);
    }

    public void reverseString(char[] s, int i, int j) {
        while (i < j && i >= 0 && j < s.length) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
        System.out.print(reverseLeftWords.reverseLeftWords("abcdefg", 2));
    }
}
