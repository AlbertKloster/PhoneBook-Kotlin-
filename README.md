# Stage 1/4: A needle in the hay
## Description
Have you ever had to use one of those 2000-plus page phone books full of all kinds of organizations and people's names printed in a small font in multiple columns on each page? Finding the information you need in such books can be an ordeal. As a matter of fact, searching through huge data sets may be a challenging task for a computer, too.

In this project, you will create a phone book; you will implement several sorting and searching algorithms and compare their efficiency in dealing with a big dataset. For this, you will need to download <a href="https://stepik.org/media/attachments/lesson/197761/directory.txt">a file</a> that contains the phone numbers of over a million people in multiple cities.

## Objectives
In this stage, you should implement the simplest possible search to find the numbers of a few people whose names are <a href="https://stepik.org/media/attachments/lesson/197761/find.txt">listed</a> in our .txt file. The data is randomly sorted, so we should use a <a href="https://hyperskill.org/learn/step/4970">Linear Search</a> to look through each of the directory entries until we find our target. While there may be faster ways to do this, avoid using optimizations like Maps in this stage - we'll get to optimizing in later stages.

It takes time to look through all the records in a big file. We recommend that you manually test your program with a simplified dataset: <a href="https://stepik.org/media/attachments/lesson/210117/small_directory.txt">small_directory.txt</a> and <a href="https://stepik.org/media/attachments/lesson/210117/small_find.txt">small_find.txt</a>. However, to pass all the tests, you will have to work with the big files mentioned above.

Note how long it takes you to do the task with linear search so that you can compare the results with those of other search methods.

To measure the time difference, you can use `System.currentTimeMillis()`.

Also notice that you don't need to read the file "directory.txt" again and again after each query. You should load all its lines into memory and measure only the search process.

Your program should output a message to show it has started searching, followed by a message stating how many entries out of the total number of targets in find.txt you were able to find along with the time taken to search for those entries (see example below).

> Please do not keep the downloaded files inside your project directory because the server may reject large files and you will see the message <b>"Failed to post submission to the Hyperskill"</b>.

## Example
Below is an example of what your output should look like (in this case, find.txt contained 500 entries and all 500 were found in the directory with the search taking 1 minute, 56 seconds, and 328 milliseconds):
```
Start searching...
Found 500 / 500 entries. Time taken: 1 min. 56 sec. 328 ms.
```
