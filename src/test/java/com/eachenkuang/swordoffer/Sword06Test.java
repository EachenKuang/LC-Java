package com.eachenkuang.swordoffer;

import com.eachenkuang.swordoffer.datastructure.Helper;
import com.eachenkuang.swordoffer.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author eachenkuang
 * @date 2022/1/29 11:33 上午
 * @description:
 */
public class Sword06Test {

    @Test
    public void testReversePrint() {
        Sword06 sword06 = new Sword06();
        int[] arrays = new int[]{1, 2, 3, 4, 5};
        ListNode node = Helper.buildListNodeFromArrays(arrays);
        int[] expectArrays = new int[]{5, 4, 3, 2, 1};
        int[] result = sword06.reversePrint(node);
        Assert.assertArrayEquals(expectArrays, result);
    }
}