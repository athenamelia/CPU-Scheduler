# CPU-Scheduler

Background:
Given a number of processes that are waiting to execute, CPU scheduling deals with the question of deciding which process should next be allocated time on the CPU. This project is to build a system that implements a “shortest job first” scheduler with aging using a priority queue that is implemented using an array-based max-heap and priority queue data structures. 
 
Written by Amelia Tran'21 @ CS205 Spring 2019

Each queue item should include three things:
1. the job’s priority, based on 1/execution time 
2. a job’s anticipated execution time 
3. the job’s “age” based on the number of processing cycles during which the job has been on the queue.  When a job is added to the queue it starts with an age of 0

