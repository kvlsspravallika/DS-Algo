package com.company.greedy;

import java.util.*;

/*
Problem Statement: You are given a set of N jobs where each job comes with a deadline and profit.
The profit can only be earned upon completing the job within its deadline. Find the number of jobs done
and the maximum profit that can be obtained. Each job takes a single unit of time and only one job can be
performed at a time.

Example 1:

Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}

Output: 2 60

Explanation: The 3rd job with a deadline 1 is performed during the first unit of time .The 1st job is performed during the second unit of time as its deadline is 4.
Profit = 40 + 20 = 60

Example 2:

Input: N = 5, Jobs = {(1,2,100),(2,1,19),(3,2,27),(4,1,25),(5,1,15)}

Output: 2 127

Explanation: The  first and third job both having a deadline 2 give the highest profit.
Profit = 100 + 27 = 127
 */
public class JobSequencing {

    public static void main(String[] args) {
        System.out.println(maxProfit(5, new int[]{1,2,3,4,5,}, new int[]{2,1,2,1,1}, new int[]{100,19,27,25,15}));
        System.out.println(maxProfit(4, new int[]{1,2,3,4}, new int[]{4,1,1,1}, new int[]{20,10,40,30}));

    }

    private static int maxProfit(int n, int[] id, int[] deadline, int[] profit){
        int maxProfit = 0;
        List<Job> input = new ArrayList<>();
        int maxDeadline=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            input.add(new Job(id[i], deadline[i], profit[i]));
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        input.sort((job1, job2) -> Integer.compare(job2.profit, job1.profit));

        int[] result = new int[maxDeadline+1];
        Arrays.fill(result, -1);
        for(int i=0;i<n;i++){
            for(int j=input.get(i).deadline;j>0;j--){
                if(result[j]==-1){
                    result[j]=i;
                    maxProfit = maxProfit+input.get(i).profit;
                    break;
                }
            }
        }

        return maxProfit;
    }
}

/*
Time Complexity: O(N log N) + O(N*M).

O(N log N ) for sorting the jobs in decreasing order of profit. O(N*M) since we are iterating through all N jobs and for every job we are checking from the last deadline, say M deadlines in the worst case.

Space Complexity: O(M) for an array that keeps track on which day which job is performed if M is the maximum deadline available.
 */

class Job{
    int jobId;
    int deadline;
    int profit;

    Job(int jobId, int deadline, int profit){
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }
}
