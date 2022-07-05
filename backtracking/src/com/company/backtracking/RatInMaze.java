package com.company.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N – 1, N – 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are ‘U'(up), ‘D'(down), ‘L’ (left), ‘R’ (right). Value 0 at a cell in the matrix represents that it is blocked and the rat cannot move to it while value 1 at a cell in the matrix represents that rat can travel through it.

        Note: In a path, no cell can be visited more than one time.

        Print the answer in lexicographical(sorted) order

        Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
        {1, 1, 0, 1},
        {1, 1, 0, 0},
        {0, 1, 1, 1}}

Output: DDRDRR DRDDRR

The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.

Example 2:

Input: N = 2
       m[][] = {{1, 0},
                {1, 0}}

Output:
 No path exists and the destination cell is blocked.
 */
public class RatInMaze {
    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        System.out.println(findPath(m,4));

        m= new int[][]{{1, 0},
            {1, 0}};
        System.out.println(findPath(m,2));

    }

    private static List<String> findPath(int[][] m, int n){
        int[][] visited = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=0;
            }
        }
        String path="";
        if(m[0][0]==1){
            List<String> result = new ArrayList<>();
            solve(0, 0, m, n, visited, path, result);
            return result;
        }
        return new ArrayList<>();
    }

    private static void solve(int i, int j, int[][] m, int n, int[][] visited, String path, List<String> result){
        if(i==n-1 && j==n-1){
            result.add(path);
            return;
        }

        // downward
        if (i + 1 < n && visited[i + 1][j] == 0 && m[i + 1][j] == 1) {
            visited[i][j] = 1;
            solve(i + 1, j, m, n, visited, path + 'D', result);
            visited[i][j] = 0;
        }

        // left
        if (j - 1 >= 0 && visited[i][j - 1] == 0 && m[i][j - 1] == 1) {
            visited[i][j] = 1;
            solve(i, j - 1, m, n, visited, path + 'L', result);
            visited[i][j] = 0;
        }

        // right
        if (j + 1 < n && visited[i][j + 1] == 0 && m[i][j + 1] == 1) {
            visited[i][j] = 1;
            solve(i, j + 1, m, n, visited, path + 'R', result);
            visited[i][j] = 0;
        }

        // upward
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && m[i - 1][j] == 1) {
            visited[i][j] = 1;
            solve(i - 1, j, m, n, visited, path + 'U', result);
            visited[i][j] = 0;
        }
    }

}

/*
    Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.

        Space Complexity:  O(m*n) ,Maximum Depth of the recursion tree(auxiliary space).

 */
