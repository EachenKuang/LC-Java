package com.eachenkuang.arrays;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.Assert;

/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>1月 22, 2022</pre> 
* @version 1.0 
*/ 
public class SolutionTest { 

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: findMaxConsecutiveOnes(int[] nums)
    *
    */
    @Test
    public void testFindMaxConsecutiveOnes() {
        //TODO: Test goes here...
        Solution solution = new Solution();
        int[] numsCase1 = {1,1,0,1,1,1,0,1};
        int[] numsCase2 = {1,0,1,1,0,1};
        int resultCase1 = 3;
        int resultCase2 = 2;
        Assert.assertEquals(solution.findMaxConsecutiveOnes(numsCase1), resultCase1);
        Assert.assertEquals(solution.findMaxConsecutiveOnes(numsCase2), resultCase2);
    }

    /**
    *
    * Method: findNumbers(int[] nums)
    *
    */
    @Test
    public void testFindNumbers() {
        //TODO: Test goes here...
        Solution solution = new Solution();
        int[] numsCase1 = {12,345,2,6,7896};
        int[] numsCase2 = {555,901,482,1771};
        int resultCase1 = 2;
        int resultCase2 = 1;
        Assert.assertEquals(solution.findNumbers(numsCase1), resultCase1);
        Assert.assertEquals(solution.findNumbers(numsCase2), resultCase2);
    }

    /**
     * Method: sortedSquares
     */
    @Test
    public void testSortedSquares() {
        Solution solution = new Solution();
        int[] numsCase1 = {-4,-1,0,3,10};
        int[] numsCase2 = {-7,-3,2,3,11};
        int[] resultCase1 = {0,1,9,16,100};
        int[] resultCase2 = {4,9,9,49,121};
        Assert.assertArrayEquals(solution.sortedSquares(numsCase1), resultCase1);
        Assert.assertArrayEquals(solution.sortedSquares(numsCase2), resultCase2);
    }

    @Test
    public void testDuplicateZeros() {
        Solution solution = new Solution();
        int[] numsCase1 = {1,0,2,3,0,4,5,0};
        int[] numsCase2 = {1,2,3};
        int[] resultCase1 = {1,0,0,2,3,0,0,4};
        int[] resultCase2 = {1,2,3};
        solution.duplicateZeros(numsCase1);
        Assert.assertArrayEquals(numsCase1, resultCase1);
        solution.duplicateZeros(numsCase2);
        Assert.assertArrayEquals(numsCase2, resultCase2);
    }
}
