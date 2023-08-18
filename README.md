# Stage 4/4: Instant search
## Description
The search is pretty fast, but is it possible to come up with something even faster? Let's try an algorithm with better complexity.

## Objectives
In the previous stage, you prepared the data using an algorithm with the complexity of `O(n log n)` and found the data using an algorithm with the complexity of `O(log n)`. In this stage, you will implement faster data preparation and a faster search. The preparation will have the complexity of `O(n)`, and the search, the complexity of `O(1)`. A <b>hash table</b> will help you with this.

You need to add all the elements to the hash table and then find the necessary phone numbers, like in the previous stages. Since the hash table is filled once, you need to measure the hash table creation time separately (just like you did with sorting in the previous stage).

Output all four approaches one after another and see which one is faster.

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

Start searching (hash table)...
Found 500 / 500 entries. Time taken: 0 min. 4 sec. 256 ms.
Creating time: 0 min. 4 sec. 121 ms.
Searching time: 0 min. 0 sec. 135 ms.
```
