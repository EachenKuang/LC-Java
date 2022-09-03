package com.eachenkuang.nowcode.chaojubian;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author eachenkuang
 * @date 2022/9/3 10:53
 * @description:
 * h:[e,f,g]:2;e:[b]:6;f:[c]:6;g:[d]:6;b:[a]:5;c:[a]:5;d:[a]:5;a:[]:3/2
 */
public class Test3 {


    public int cal(int[][] graph, int[] times, int concurrent) {
        if (concurrent == 1) {
            return Arrays.stream(times).sum();
        }
        int[] inDegree = new int[times.length]; // 入度矩阵
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times.length; j++) {
                inDegree[i] += graph[j][i];
            }
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < times.length; i++) {
            if (inDegree[i] == 0) {
                deque.push(i);
            }
        }
        int result = 0;
        while (!deque.isEmpty()) {
            int index = deque.pop();
            // 需要将所有入度减一
        }
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] taskStrings = line.split(";");
        int taskCount = taskStrings.length; // 任务的长度，用于定义数组
        int[] times = new int[taskCount]; // a - 0， b- 1 任务数不会超过100个
        int[][] graph = new int[taskCount][taskCount]; // 图
        int concurrent = 1;
        int index = 0;
        Map<String, Integer> dict = new HashMap<>(); // 用于记录字符对应的index
        for (int i = 0; i < taskCount; i++) {
            String taskString = taskStrings[i];
            String[] parts = taskString.split(":");

            // 处理当前的任务
            String curTask = parts[0];
            if (!dict.containsKey(curTask)) {
                dict.put(curTask, index++); // 存入字典
            }
            // 处理依赖的任务
            String depends = parts[1].substring(1,parts[1].length()-1);
            if (!depends.equals("")) {
                String[] dependTasks = depends.split(",");
                for (String task: dependTasks
                     ) {
                    if (!dict.containsKey(task)) {
                        dict.put(task, index++); // 存入字典
                    }
                    // 构建图
                    graph[dict.get(curTask)][dict.get(task)] = 1;
                }
            }
            // 处理时间
            String timeString = parts[2];
            if (parts[2].contains("/")) {
                String[] pair = parts[2].split("/");
                timeString = pair[0];
                concurrent = Integer.parseInt(pair[1]);
            }
            times[dict.get(curTask)] = Integer.parseInt(timeString);
        }

    }
}

//class Node {
//    int duration; // 持续时间
//    String name;
//    List<Node> dependencies;  // 依赖项
//    public Node() {}
//    public Node(String name) {
//        this.name = name;
//    }
//    public Node(int duration, String name, List<Node> dependencies) {
//        this.dependencies =dependencies;
//        this.duration = duration;
//    }
//}
