package com.eachenkuang.swordoffer.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author eachenkuang
 * @date 2022/1/29 11:44 上午
 * @description:
 */
public class HelperTest {

    int[] arrays = {1,2,3,4,5,6,7};
    int[] arrays2 = {2,3,4,5,6,78};

    @Test
    public void testBuildListNodeFromArrays() {
        ListNode node = Helper.buildListNodeFromArrays(arrays);
        int[] array = Helper.buildArraysFromListNode(node);
        Assert.assertArrayEquals(array, arrays);
    }

    @Test
    public void testBuildArraysFromListNode() {
        ListNode node = Helper.buildListNodeFromArrays(arrays2);
        int[] array = Helper.buildArraysFromListNode(node);
        Assert.assertArrayEquals(array, arrays2);
    }
}