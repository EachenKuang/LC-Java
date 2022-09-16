package com.eachenkuang.company.bytedance;

import java.util.Scanner;


// 我叫王大锤，是一名特工。我刚刚接到任务：在字节跳动大街进行埋伏，抓捕恐怖分子孔连顺。和我一起行动的还有另外两名特工，我提议

// 1. 我们在字节跳动大街的 N 个建筑中选定 3 个埋伏地点。
// 2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过 D 。

// 我特喵是个天才! 经过精密的计算，我们从X种可行的埋伏方案中选择了一种。这个方案万无一失，颤抖吧，孔连顺！
// ……
// 万万没想到，计划还是失败了，孔连顺化妆成小龙女，混在cosplay的队伍中逃出了字节跳动大街。只怪他的伪装太成功了，就是杨过本人来了也发现不了的！

// 请听题：给定 N（可选作为埋伏点的建筑物数）、 D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
public class Solution2 {


    // List<Integer> paths = new ArrayList<>();
    // int result = 0; // 保存情况
    // /**
    //  * 这个是回溯，就是在D个建筑物中，是否放人的情况 N里面选出3个出来，然后计算是否可行, 3个特工
    //  */
    // public int catchKong(int N, int D, int[] position) {
    //     // 剪枝
    //     backtrack(N,D,position,0);
    //     return result;
    // }

    // public void backtrack(int N, int D, int[] position, int startIndex) {
    //     if (paths.size() == 3) {
    //         if (paths.get(paths.size()-1) - paths.get(0) <= D) {
    //             result++;
    //             result = result % 99997867;
    //         }
    //         return;
    //     }
    //     // 剪枝
    //     for (int i = startIndex; i < position.length - (3 - paths.size()) + 1; i++) {
    //         // 小剪支
    //         if (paths.size() > 0 && position[i] - paths.get(0) > D) {
    //             break;
    //         }
    //         paths.add(position[i]);
    //         backtrack(N, D, position, i+1);
    //         paths.remove(paths.size()-1);
    //     }
    // }

    // public static void main(String[] args) {
    //     // Solution2 solution = new Solution2();
    //     // int[] positions = {1,2,3,4};
    //     // int result = solution.catchKong(4, 3, positions);
    //     // System.out.print(result);
    //     Scanner in = new Scanner(System.in); 
    //     int N = in.nextInt();
    //     int D = in.nextInt();
    //     in.nextLine(); // 去除空格
    //     String line = in.nextLine();
    //     String[] positionsStr = line.split(" ");
    //     int[] positions = new int[positionsStr.length];
    //     for (int i = 0; i < positionsStr.length; i++) {
    //         positions[i] = Integer.valueOf(positionsStr[i]);
    //     }
    //     Solution2 solution = new Solution2();
    //     System.out.println(solution.catchKong(N, D, positions));   
    // }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int d = sc.nextInt();
            int[] position = new int[n];
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                position[i] = sc.nextInt();
            }
            run(n,d,position);
        }
    }
 
    private static void run(int n, int d, int[] position) {
        long sum = 0L;
        long mod = 99997867;
        for (int i = 0,j=0; i < n; i++) {
            //从第三个开始判断，判断是否违法，如果违法j++
            while (i>=2 && position[i] - position [j] >d){
                j++;
            }
            //计算合法的次数,n(n-i)/2
            sum += (long)(i-j)*(long)(i-j-1)/2;
        }
        System.out.println(sum%mod);
    }
    
}
