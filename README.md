# Stage 3/4: Need for speed
## Description
Now, let's use even faster methods to sort the list of numbers and to search in the list. In this stage, we will compare the efficiency of all three approaches.

## Objectives
Like in the previous stage, you should first sort the list of phone numbers by the owner’s name and then search for the numbers of the 500 people from the list given in the first stage. Remember: to get decent and comparable results, you should put all the algorithms in the same initial conditions.

For sorting, use the quick sort algorithm, and for searching, the binary search algorithm.

Output all three approaches one after another and see which one is faster.

## Examples
An output example is shown below. Note that you can get totally different sorting and searching times!
```
Start searching (linear search)...
Found 500 / 500 entries. Time taken: 1 min. 56 sec. 328 ms.

Start searching (bubble sort + jump search)...
Found 500 / 500 entries. Time taken: 9 min. 15 sec. 291 ms.
Sorting time: 8 min. 45 sec. 251 ms.
Searching time: 0 min. 30 sec. 40 ms.

Start searching (quick sort + binary search)...
Found 500 / 500 entries. Time taken: 1 min. 21 sec. 996 ms.
Sorting time: 1 min. 17 sec. 381 ms.
Searching time: 0 min. 4 sec. 615 ms.
```
