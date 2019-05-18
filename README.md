# CPU-Scheduler

Background:
Given a number of processes that are waiting to execute, CPU scheduling deals with the question of deciding which process should next be allocated time on the CPU.  

The most straightforward approach is to use a standard queue.  Under that scheme, each process executes in order.  Once a process is using the CPU it will run to completion, and then the next process in the queue starts execution.  This can seem very inefficient because the queue can fill up with lots of short jobs while one long job executes.  We certainly would not want to use this approach, for example, in an interactive system because the user could be waiting a long time for a system response while some long process was executing.

We can improve the situation by using preemptive scheduling which uses priority queue - “shortest job first” scheduling.  In this scheme, each job is assigned a priority, perhaps based on the expected length of execution.  If the priority is computed using 1/(expected length of execution) then short jobs will have a high (large) priority value, long jobs will have a low (small) priority value.  Jobs waiting to execute are stored in a priority queue based on priority value and the highest (largest) priority job is the next one to execute each time the CPU becomes available.

The problem with the “shortest job first” approach is that a long process could sit on the queue forever while new shorter processes jump ahead of it.  We can limit how long a job languishes on the queue by allowing a process’s priority to improve (increase) as the job ages.  We can do this by gradually increasing the priority of processes that have been in the system for a long period of time.

This project is to build a system that implements a “shortest job first” scheduler with aging based on the following requirements and properties:
. Each input to the system will be a value that represents the anticipated execution time of a job (length of CPU time needed for execution) in milliseconds. This data will be provided in a file of integer values (file name will be a command line argument provided at run time). Typical values range 1 - 20000.
. System output will be the execution time of jobs in the order in which they would be executed by the CPU. The problem will be solved using a priority queue that is implemented using an array-based max-heap (a heap with the max-ordering property). The initial priority value for each job should be 1/(expected length of execution) as discussed above.

After getting the file name from the command line, the system will read the first 5 job times from the data file, placing each of them into the priority queue based on their execution time. Then the system will enter a loop that runs as long as there is data in the file or jobs on the queue waiting to execute. Each time through the loop, the system should report (output) the next job that should be executed and remove it from the queue. Adjust the queue when an item is removed. Read in the next input value, if there is one, and place it appropriately on the priority queue (adjusting the queue again).

Each queue item should include three things:
1. the job’s priority, based on 1/execution time (careful: remember how Java does division!)
2. a job’s anticipated execution time 
3. the job’s “age” based on the number of processing cycles during which the job has been on the queue.  When a job is added to the queue it starts with an age of 0

