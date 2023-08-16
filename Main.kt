package phonebook

import phonebook.Constants.Companion.FIND

const val MS_IN_MIN = 60_000
const val MS_IN_SEC = 1_000
fun main() {
    val databaseService = DatabaseService()
    val searchList = FileHandler.readNames(FIND)

    println("Start searching...")
    val startTime = System.currentTimeMillis()
    val foundEntries = databaseService.findAllEntriesForNames(searchList)
    val finishTime = System.currentTimeMillis()

    val searchTime = finishTime - startTime

    val min = searchTime / MS_IN_MIN
    val sec = (searchTime - min * MS_IN_MIN) / MS_IN_SEC
    val ms = searchTime % MS_IN_SEC

    println("Found ${foundEntries.size} / ${searchList.size} entries. Time taken: $min min. $sec sec. $ms ms.")


}
