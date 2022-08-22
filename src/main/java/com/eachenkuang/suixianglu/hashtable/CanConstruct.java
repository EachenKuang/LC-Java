package com.eachenkuang.suixianglu.hashtable;

/**
 * @author eachenkuang
 * @date 2022/8/22 10:36 AM
 * @description:
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class CanConstruct {
    /**
     * 只需要满足信中的对应字母个数都小于杂志中的字母个数，与 IsAnagram有异曲同工之妙
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] alphas = new int[26];
        for (char c: magazine.toCharArray()) {
            alphas[c -'a'] += 1;
        }
        for (char c: ransomNote.toCharArray()) {
            alphas[c- 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (alphas[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
