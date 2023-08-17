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
    var stopped = false
    val sortedEntries = try {
        bubbleSorter.sort(database.data, (finishTimeLinear - startTimeLinear) * 10)
    } catch (e: RuntimeException) {
        stopped = true
        emptyList()
    }
    val finishTimeBubble = System.currentTimeMillis()

    val startTimeSearch = System.currentTimeMillis()
    val foundEntries = if (stopped) searchByList(LinearSearcher(), database.data, searchList) else searchByList(JumpSearcher(), sortedEntries, searchList)
    val finishTimeSearch = System.currentTimeMillis()

    printResult(startTimeBubble, finishTimeSearch, foundEntries, searchList)
    println("Sorting time: ${parseTime(finishTimeBubble - startTimeBubble) + if (stopped) " - STOPPED, moved to linear search" else ""}")
    println("Searching time: ${parseTime(finishTimeSearch - startTimeSearch)}")

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
