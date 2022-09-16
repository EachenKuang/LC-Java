package com.eachenkuang.company.bytedance;

import java.util.Scanner;

// Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为的商品，请问最少他会收到多少硬币？
// 背包问题
public class Solution6 {
    
    public static int greedy(int price) {
        int[] values = {64,16,4,1};
        int left = 1024 - price;
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            int temp = left / values[i];
            if (temp > 0) {
                left -= temp * values[i];
                count += temp;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int price = in.nextInt();
        System.out.print(greedy(price));
    }
}
