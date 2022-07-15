package com.company.greedy;

import java.util.*;

/*
Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end each of size
N.For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the
ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one
meeting can happen in the room at a  particular time. Print the order in which these meetings will be
performed.

Example:

Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}

Output: 1 2 4 5
 */
public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        System.out.println(getMeetingInOrder(new int[]{1,3,0,5,8,5}, new int[]{2,4,5,7,9,9}, 6));
    }

    private static List<Integer> getMeetingInOrder(int[] start, int[] end, int n){
        List<Integer> result = new ArrayList<>();
        List<Meeting> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Meeting(i, start[i], end[i]));
        }
        list.sort((m1, m2) -> {
            if (m1.endTime != m2.endTime) {
                return Integer.compare(m1.endTime, m2.endTime);
            }
            return Integer.compare(m1.meetingId, m2.meetingId);
        });

        result.add(list.get(0).meetingId);
        int endLimit = list.get(0).endTime;
        for(int i=1;i<n;i++){
            if(list.get(i).startTime > endLimit){
                result.add(list.get(i).meetingId);
                endLimit = list.get(i).endTime;
            }
        }
        return  result;
    }
}

class Meeting{

    int meetingId;
    int startTime;
    int endTime;

    Meeting(int meetingId, int startTime, int endTime){
        this.meetingId = meetingId;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
/*
Time Complexity: O(n) to iterate through every position and insert them in a data structure. O(n log n)  to sort the data structure in ascending order of end time. O(n)  to iterate through the positions and check which meeting can be performed.

Overall : O(n) +O(n log n) + O(n) ~O(n log n)

Space Complexity: O(n)  since we used an additional data structure for storing the start time, end time, and meeting no.
 */
