package com.eachenkuang.swordoffer;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author eachenkuang
 * @date 2022/1/26 7:29 下午
 * @description:
 */
public class Sword04Test {

    @Test
    public void testFindNumberIn2DArray() {
        int[][] numsCase1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] numsCase2 = {
                {1, 5, 7, 11, 15},
                {2, 7, 8, 12, 23},
                {10, 13, 14, 19, 24},
                {18, 22, 23, 26, 100}
        };
        int param1 = 12;
        int param2 = 16;
        Sword04 sword04 = new Sword04();
        Assert.assertTrue(sword04.findNumberIn2DArray(numsCase1, param1));
        Assert.assertFalse(sword04.findNumberIn2DArray(numsCase2, param2));
    }

    @Test
    public void testFindNumberIn2DArray_2() {
        int[][] numsCase1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] numsCase2 = {
                {1, 5, 7, 11, 15},
                {2, 7, 8, 12, 23},
                {10, 13, 14, 19, 24},
                {18, 22, 23, 26, 100}
        };
        int param1 = 12;
        int param2 = 15;
        Sword04 sword04 = new Sword04();
        Assert.assertTrue(sword04.findNumberIn2DArray_2(numsCase1, param1));
        Assert.assertTrue(sword04.findNumberIn2DArray_2(numsCase2, param2));
    }
}