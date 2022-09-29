package com.eachenkuang.tpc2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author eachenkuang
 * @date 2022/9/27 19:04
 * @description:
 *
 *
 * 2
 * 2
 * 2 3
 * 7
 * 2 1
 * 2 1
 * 1 4
 * 2 2
 * 2 3
 * 2 2
 * 2 104
 * 1
 * 1
 * 1
 * 2 1000000000
 *
 * 1
 * 2
 * 2
 * 3
 * 1
 * 3
 * 1
 */
public class Solution1 {
    public static List<Integer> listen(List<Integer> music, int[][] objects) {
        int offset = 0; // 当前歌的 offset
        int index = 0; // 第几首歌
        List<Integer> result = new ArrayList<>();
        List<Integer> musicAdd = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < music.size(); i++) {
            sum += music.get(i);
            musicAdd.add(sum);
        }
        for (int i = 0; i < objects.length; i++) {
            if (objects[i][0] == 1) {
                music.add(objects[i][1]);
                musicAdd.add(musicAdd.get(musicAdd.size()-1)+objects[i][1]);
            } else {
                int time = objects[i][1];
                // 计算下一次的 index 以及 offset
                while (time > 0) {
                    int leftTime = music.get(index) - offset;
                    if (time >= leftTime) {
                        time -= leftTime;
                        index = (index+1) % music.size();
                        offset = 0;
                    } else {
                        offset = time;
                        break;
                    }
                }
                result.add(index+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < T; i++) {
            try {
                int musicCount = sc.nextInt();
                sc.nextLine();
                List<Integer> music = new ArrayList<>();
                for (int j = 0; j < musicCount; j++) {
                    music.add(sc.nextInt());
                }
                sc.nextLine();
                int objectCount = sc.nextInt();
                sc.nextLine();
                int[][] objects = new int[objectCount][2];
                for (int j = 0; j < objectCount; j++) {
                    objects[j][0] = sc.nextInt();
                    objects[j][1] = sc.nextInt();
                    sc.nextLine();
                }
                List<Integer> result = listen(music, objects);
                for (int j = 0; j < result.size(); j++) {
                    System.out.println(result.get(j));
                }
            } catch (Exception e) {

            }

        }

    }
}
