package com.eachenkuang.suixianglu.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author eachenkuang
 * @date 2022/8/22 10:02 AM
 * @description:
 */
public class IsHappy {
    /**
     * 因为可能会出现无限循环，需要使用一个set来存储对应出现的 sum, 如果出现重复，则说明不是开心树
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            set.add(n);
            n = getBitSum(n);
            if (n==1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
        }
    }

    public static int getBitSum(int n) {
        int result = 0;
        while (n > 0) {
            int bitNum = n%10;
            n /= 10;
            result += bitNum * bitNum;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 19;
        System.out.println(getBitSum(n));
        System.out.println(isHappy(n));
    }
}
