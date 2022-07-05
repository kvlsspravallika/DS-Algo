package com.company.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(nQueens(4));
        System.out.println(nQueens2(4));
        System.out.println(nQueens(8));
        System.out.println(nQueens2(8));
    }

    private static List<List<String>> nQueens(int n){
        char[][] board = new char[n][n];
        for(int i=0;i< board.length;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(0, board, result);
        return result;
    }

    private static void dfs(int col, char[][] board, List<List<String>> result) {
        if(col==board.length){
            result.add(construct(board));
            return;
        }

        for(int row=0;row<board.length;row++){
            if(isValid(row, col, board)){
                board[row][col]='Q';
                dfs(col+1, board, result);
                board[row][col]='.';
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List < String > res = new LinkedList< String >();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private static boolean isValid(int row, int col, char[][] board) {
        int dupRow = row;
        int dupCol = col;

        while(row>=0 && col>=0){
            if(board[row--][col--]=='Q'){
                return false;
            }
        }

        row=dupRow;
        col=dupCol;

        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = dupRow;
        col = dupCol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }


    private static List<List<String>> nQueens2(int n){
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }

    static void solve(int col, char[][] board, List < List < String >> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }





}
