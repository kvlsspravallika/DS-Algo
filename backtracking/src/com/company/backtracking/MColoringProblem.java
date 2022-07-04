package com.company.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColoringProblem {
    public static void main(String[] args) {
        int n = 4;
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(1);
        graph[1].add(0);
        graph[1].add(2);
        graph[2].add(1);
        graph[2].add(3);
        graph[3].add(2);
        graph[3].add(0);
        graph[0].add(3);
        graph[0].add(2);
        graph[2].add(0);
        System.out.println(graphColoring(graph, 3));
        System.out.println(graphColoring(graph, 2));
    }

    public static boolean graphColoring(List<Integer>[] graph, int numColors) {
        // Write your code here
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, 0);
        if(solve(0, graph, colors, n, numColors)){
            return true;
        }
        return false;
    }

    private static boolean solve(int node, List<Integer>[] graph, int[] colors, int n, int numColors) {
        if(node==n){
            return true;
        }
        for(int i=1;i<=numColors;i++){
            if(isSafe(node, graph, colors, n, i)){
               colors[node]=i;
               if(solve(node + 1, graph, colors, n, numColors)) {
                   return true;
               }
               colors[node]=0;
            }
        }
        return false;
    }

    private static boolean isSafe(int node, List<Integer>[] graph, int[] colors, int n, int col) {
        for(int currentColor : graph[node]){
            if(colors[currentColor] == col){
                return false;
            }
        }
        return true;
    }

}
