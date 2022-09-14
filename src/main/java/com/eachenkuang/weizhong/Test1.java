package com.eachenkuang.weizhong;

/**
 * @author eachenkuang
 * @date 2022/9/6 19:25
 * @description:
 * 梯度 1-12
 */
public class Test1 {

    /**
     * 要求：
     * 清晰简洁
     *
     * 梯段收费，可以定义一个数组保存梯度，另一个数组保存对应梯度的价格
     * @param transactionCount 交易数量
     * @return 费用
     */

    // 梯度数组，闭区间
    private int[] countLevel = {5, 15, 50, 100, 500, 1000, 2000, 3000, 4000, 5000, 6000, Integer.MAX_VALUE};

    private int[] feeLevel = {30, 15, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public int fee(int transactionCount) {
        int result = 0;
        int preLevel = 0;
        for (int i = 0; i < countLevel.length; i++) {
            if (transactionCount <= countLevel[i]) {
                // 小于当前区间
                result += (transactionCount - preLevel) * feeLevel[i];
                return result;
            } else {
                // 计算当前区间的费用
                result += (countLevel[i] - preLevel) * feeLevel[i];
            }
            // 保存上一次的level
            preLevel = countLevel[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Test1 solution = new Test1();
        System.out.print(solution.fee(6));
    }
}
