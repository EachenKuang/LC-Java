package com.eachenkuang.swordoffer;

/**
 * @author eachenkuang
 * @date 2022/9/21 14:48
 * @description:
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 */
public class Sword12 {
    /**
     * 回溯法
     *
     * 结束条件
     * 循环
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int start = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 只要找到就返回
                if (backtrace(start, board, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtrace(int start, char[][] board, String word, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '0' || word.charAt(start) != board[i][j]) {
            return false;
        }
        if (start == word.length()-1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '0';
        // 递归
        boolean result = backtrace(start+1, board, word, i+1, j)
                || backtrace(start+1, board, word, i, j-1)
                || backtrace(start+1, board, word, i-1, j)
                || backtrace(start+1, board, word, i, j+1);
        // 回溯
        board[i][j] = temp;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'A','B','C', 'D'},
                new char[]{'E','F','G', 'H'},
                new char[]{'A','B','C', 'V'}
        };
        String word = "ABCDHVC";
        System.out.println(exist(board, word));

    }
}
