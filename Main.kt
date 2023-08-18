package phonebook

import phonebook.Constants.Companion.DIRECTORY
import phonebook.Constants.Companion.FIND

fun main() {
    val database = Database(DIRECTORY)
    val searchList = FileHandler.readNames(FIND)

    println("Start searching (linear search)...")
    val startTimeLinear = System.currentTimeMillis()
    val foundEntriesLinear = searchByList(LinearSearcher(), database.data, searchList)
    val finishTimeLinear = System.currentTimeMillis()
    printResult(startTimeLinear, finishTimeLinear, foundEntriesLinear, searchList)



    println("\nStart searching (bubble sort + jump search)...")
    val bubbleSorter = BubbleSorter()
    val startTimeBubble = System.currentTimeMillis()
    var bubbleStopped = false
    val bubbleSortedEntries = try {
        bubbleSorter.sort(database.data, (finishTimeLinear - startTimeLinear) * 10)
    } catch (e: RuntimeException) {
        bubbleStopped = true
        emptyList()
    }
    val finishTimeBubble = System.currentTimeMillis()

    val startTimeSearch = System.currentTimeMillis()
    val foundEntries = if (bubbleStopped) searchByList(LinearSearcher(), database.data, searchList) else searchByList(JumpSearcher(), bubbleSortedEntries, searchList)
    val finishTimeSearch = System.currentTimeMillis()

    printResult(startTimeBubble, finishTimeSearch, foundEntries, searchList)
    println("Sorting time: ${parseTime(finishTimeBubble - startTimeBubble) + if (bubbleStopped) " - STOPPED, moved to linear search" else ""}")
    println("Searching time: ${parseTime(finishTimeSearch - startTimeSearch)}")



    println("\nStart searching (quick sort + binary search)...")
    val quickSorter = QuickSorter()
    val startTimeQuick = System.currentTimeMillis()
    var quickStopped = false
    val quickSortedEntries = try {
        quickSorter.sort(database.data, (finishTimeLinear - startTimeLinear) * 10)
    } catch (e: RuntimeException) {
        quickStopped = true
        emptyList()
    }
    val finishTimeQuick = System.currentTimeMillis()

    val startTimeSearchQuickBin = System.currentTimeMillis()
    val foundEntriesQuickBin = if (quickStopped) searchByList(LinearSearcher(), database.data, searchList) else searchByList(BinarySearcher(), quickSortedEntries, searchList)
    val finishTimeSearchQuickBin = System.currentTimeMillis()

    printResult(startTimeQuick, finishTimeSearchQuickBin, foundEntriesQuickBin, searchList)
    println("Sorting time: ${parseTime(finishTimeQuick - startTimeQuick) + if (quickStopped) " - STOPPED, moved to linear search" else ""}")
    println("Searching time: ${parseTime(finishTimeSearchQuickBin - startTimeSearchQuickBin)}")

}

private fun printResult(startTime: Long, finishTime: Long, foundEntries: List<Entry>, searchList: List<String>) {
    val searchTime = finishTime - startTime
    println("Found ${foundEntries.size} / ${searchList.size} entries. Time taken: ${parseTime(searchTime)}")
}

private fun parseTime(time: Long): String {
    val min = time / 60_000
    val sec = (time - min * 60_000) / 1_000
    val ms = time % 1_000
    return "$min min. $sec sec. $ms ms."
}

private fun searchByList(searcher: Searcher, entries: List<Entry>, names: List<String>): List<Entry> {
    val foundEntries = mutableListOf<Entry>()
    for (name in names) {
        val foundEntry = searcher.search(entries, name)
        if (foundEntry != null)
            foundEntries.add(foundEntry)
    }
    return foundEntries
}
