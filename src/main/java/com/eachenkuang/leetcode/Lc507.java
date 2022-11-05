package com.eachenkuang.leetcode;

/**
 * @author eachenkuang
 * @date 2022/10/26 09:34
 * @description:
对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。

给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。

示例 1：

输入：num = 28
输出：true
解释：28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, 和 14 是 28 的所有正因子。
示例 2：

输入：num = 7
输出：false

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/perfect-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lc507 {
    /**
     * 枚举法
     * 时间复杂度O(num)
     * 空间复杂度O(1)
     * @param num
     * @return
     */
    public static boolean checkPerfectNumber(int num) {
        int count = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                count += i;
                if (count > num) {
                    return false;
                }
            }
        }
        return count == num;
    }
    /**
     * 枚举法改进
     * 时间复杂度O(根号下num)
     * 空间复杂度O(1)
     * @param num
     * @return
     */
    public boolean checkPerfectNumber2(int num) {
        if (num == 1) {
            return false;
        }

        int sum = 1;
        for (int d = 2; d * d <= num; ++d) {
            if (num % d == 0) {
                sum += d;
                if (d * d < num) {
                    sum += num / d;
                }
            }
        }
        return sum == num;
    }

     public static void main(String[] args) {
         int num = 28;
         System.out.print(checkPerfectNumber(num));
     }
}
