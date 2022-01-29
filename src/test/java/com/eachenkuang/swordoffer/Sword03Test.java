package com.eachenkuang.swordoffer;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author eachenkuang
 * @date 2022/1/26 7:07 下午
 * @description:
 */
public class Sword03Test {

    @Test
    public void testFindRepeatNumber() {

        int[] numsCase1 = {1,0,2,3,0,4,5,0};
        int[] numsCase2 = {1,2,3,2};
        int resultCase1 = 0;
        int resultCase2 = 2;

        Sword03 sword03 = new Sword03();
        Assert.assertEquals(sword03.findRepeatNumber(numsCase1), resultCase1);
        Assert.assertEquals(sword03.findRepeatNumber(numsCase2), resultCase2);
    }
}