package com.company.backtracking;

/*
Given a 9×9 incomplete sudoku, solve it such that it becomes valid sudoku. Valid sudoku has the following properties.

        1. All the rows should be filled with numbers(1 – 9) exactly once.

        2. All the columns should be filled with numbers(1 – 9) exactly once.

        3. Each 3×3 submatrix should be filled with numbers(1 – 9) exactly once.

        Note: Character ‘.’ indicates empty cell.
 */
public class SudokoSolver {
    public static void main(String[] args) {
        char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solve(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    private static boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isValid(ch, i, j, board)){
                            board[i][j]=ch;

                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char ch, int row, int col, char[][] board){
        for(int i=0;i<9;i++){
            if(board[i][col]==ch){
                return false;
            }
            if(board[row][i]==ch){
                return false;
            }

            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3]==ch){
                return false;
            }
        }
        return true;
    }
}
/*

    Time Complexity: O(9(n ^ 2)), in the worst case, for each cell in the n2 board, we have 9 possible numbers.

        Space Complexity: O(1), since we are refilling the given board itself, there is no extra space required, so constant space complexity.

 */
