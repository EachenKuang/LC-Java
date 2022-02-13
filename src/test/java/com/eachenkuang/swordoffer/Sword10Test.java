package com.eachenkuang.swordoffer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author eachenkuang
 * @date 2022/2/13 4:52 下午
 * @description:
 */
public class Sword10Test {

    @Test
    public void fib() {
        Sword10 sword10 = new Sword10();

        Assert.assertEquals(sword10.fib(0), 0);
        Assert.assertEquals(sword10.fib(1), 1);
        Assert.assertEquals(sword10.fib(2), 1);
        Assert.assertEquals(sword10.fib(3), 2);
        Assert.assertEquals(sword10.fib(4), 3);
    }

    @Test
    public void fib2() {
        Sword10 sword10 = new Sword10();

        Assert.assertEquals(sword10.fib2(0), 0);
        Assert.assertEquals(sword10.fib2(1), 1);
        Assert.assertEquals(sword10.fib2(2), 1);
        Assert.assertEquals(sword10.fib2(3), 2);
        Assert.assertEquals(sword10.fib2(1000), 517691607);
    }
}