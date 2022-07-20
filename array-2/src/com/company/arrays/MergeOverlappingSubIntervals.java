package com.company.arrays;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array
 of non-overlapping intervals.

 Example 1:

Input: intervals=[[1,3],[2,6],[8,10],[15,18]]

Output: [[1,6],[8,10],[15,18]]

Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
 intervals.

Example 2:

Input: [[1,4],[4,5]]

Output: [[1,5]]

Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6] intervals.
 */
public class MergeOverlappingSubIntervals {

    public static void main(String[] args) {
        System.out.println(mergeSubIntervals(Arrays.asList(new Interval(1, 6),
                new Interval(8,10), new Interval(15,18))));
        System.out.println(mergeSubIntervals(Arrays.asList(new Interval(1, 4),
                new Interval(4,5), new Interval(15,18))));
        System.out.println(mergeSubIntervals(Arrays.asList(new Interval(1, 4),
                new Interval(5,6))));
    }

    private static List<Interval> mergeSubIntervals(List<Interval> list){
        Collections.sort(list, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> result = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(result.isEmpty()){
                result.add(list.get(i));
            }else{
                Interval prev = result.get(result.size()-1);
                Interval curr = list.get(i);
                if(curr.start <= prev.end){
                    prev.setEnd(Math.max(curr.end, prev.end));
                }else{
                    result.add(list.get(i));
                }
            }
        }

        return result;
    }
}


class Interval{
    int start;
    int end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

/*
Time Complexity: O(NlogN)+O(N*N). O(NlogN) for sorting the array, and O(N*N) because we are checking to the right for each index which is a nested loop.

Space Complexity: O(N), as we are using a separate data structure.
 */
