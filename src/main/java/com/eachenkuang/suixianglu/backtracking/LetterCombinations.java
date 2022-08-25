package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eachenkuang
 * @date 2022/8/25 10:34 AM
 * @description:
 */
public class LetterCombinations {

    List<String> results = new ArrayList<>(); // 存储最终结果
    StringBuilder paths = new StringBuilder(); // 存储当前路径

    /**
     * 时间复杂度：O(3^n~4^n)
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return results;
        }
        // 初始化 Mapping 这里也可以使用一个 String 数组来存储，使用下标来标志
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backTracking(digits, 0, phoneMap);
        return results;
    }

    public void backTracking(String digits, int index, Map<Character, String> phoneMap) {
        if (index == digits.length()) {
            results.add(paths.toString());
            return;
        }
        char alpha = digits.charAt(index);
        String letters = phoneMap.get(alpha);
        for (int i = 0; i < letters.length(); i++) {
            paths.append(letters.charAt(i));
            backTracking(digits, index+1, phoneMap); // 处理下一个index
            paths.deleteCharAt(paths.length()-1); // 回溯
        }
    }


}
