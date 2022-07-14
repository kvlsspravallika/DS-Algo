package com.company.Arrays1;

/*
Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its
        entire column and row to 0 and then return the matrix.

Examples 1:

Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.

Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};
        setMatrixZeroes(matrix);
        print(matrix);
        System.out.println("----------");
        matrix = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        setMatrixZeroes(matrix);
        print(matrix);
    }


    private static void print(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    private static void setMatrixZeroes(int[][] matrix){
        int col0=1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            if(matrix[i][0]==0){
                col0=0;
            }
            for(int j=1;j<cols;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
            if(col0==0){
                matrix[i][0]=0;
            }
        }
    }
}
/*
    Time Complexity: O(2*(N*M)), as we are traversing two times in a matrix,

        Space Complexity: O(1).

 */
