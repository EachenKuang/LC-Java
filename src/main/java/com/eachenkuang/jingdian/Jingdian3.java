package com.eachenkuang.jingdian;

/**
 * @author eachenkuang
 * @date 2022/5/15 10:56 上午
 * @description:
 */
public class Jingdian3 {
    /**
     * 该题有说的，预留了足够多的空格，所以 length 其实是指字符的普通长度，后面还有预留长度
     * @param S
     * @param length
     * @return
     */
    public String replaceSpaces(String S, int length) {
        //先把字符串转化为字符数组
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            //如果遇到空格就把他转化为"%20"
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - index - 1);
    }

    public static void main(String[] args) {
        Jingdian3 jingdian3 = new Jingdian3();
        System.out.println(jingdian3.replaceSpaces("Mr John Smith    ", 13));
    }
}
