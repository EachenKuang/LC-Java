package com.eachenkuang.company.bytedance;

import java.util.Scanner;

class Solution1 {
    
    public static String adjust(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            String line = in.nextLine();
            // 处理每个字符串然后输出
            System.out.println(adjust(line));
        }
    }
}