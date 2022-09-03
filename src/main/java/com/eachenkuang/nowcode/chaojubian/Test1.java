package com.eachenkuang.nowcode.chaojubian;

import java.util.Scanner;
/**
 * @author eachenkuang
 * @date 2022/9/3 09:17
 * @description:
 */
public class Test1 {



    // 本题为考试单行多行输入输出规范示例，无需提交，不计分。
    // 名单（5个）
    // 人名的幸运值，（a,A = 1）累加就是幸运值  aaa 的幸运值为3
    // 选一个最接近的人，如果有多个，选最后一个输入的名字优先
    //
    // 约束：人名字符串长度不超过10,也就是最多10个字符串的名字，大小写是一致的。 AAa aaa

    /**
     * 计算幸运值
     * @return
     */
    public static int calLucky(String s) {
        int luck = 0;
        for (char ch: s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                luck += ch - 'a' + 1;
            } else {
                luck += ch - 'A' + 1;
            }
        }
        return luck;
    }

    public static String findLuckyPerson(String candidate, String[] persons) {
        int luckCandidate = calLucky(candidate);
        int index = 0; // 默认选择第一个人
        int luckyDiff = Math.abs(calLucky(persons[0]) - luckCandidate); // 幸运值差值
        for (int i = 1; i < persons.length; i++) {
            int tempDiff = Math.abs(calLucky(persons[i]) - luckCandidate);
            if (tempDiff <= luckyDiff) {
                luckyDiff = tempDiff;
                index = i;
            }
        }
        return persons[index];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String candidate = in.next();
        String[] persons = in.nextLine().split(" ");
        System.out.print(findLuckyPerson(candidate, persons));
    }
}