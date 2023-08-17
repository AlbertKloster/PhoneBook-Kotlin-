package phonebook

import java.lang.RuntimeException

class BubbleSorter : Sorter {
    override fun sort(list: List<Entry>, timeLimit: Long): List<Entry> {
        val entries = mutableListOf<Entry>()
        entries.addAll(list)
        val n = entries.size
        var swapped: Boolean
        val startTime = System.currentTimeMillis()
        do {
            swapped = false
            for (i in 0 until n - 1) {
                if (entries[i].name > entries[i + 1].name) {
                    val temp = entries[i]
                    entries[i] = entries[i + 1]
                    entries[i + 1] = temp
                    swapped = true
                }
                if (timeLimit > 0 && System.currentTimeMillis() - startTime > timeLimit)
                    throw RuntimeException("Time exceeded")
            }
        } while (swapped)
        return entries
    }
}