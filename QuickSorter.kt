package phonebook

import java.lang.RuntimeException

class QuickSorter : Sorter {
    override fun sort(list: List<Entry>, timeLimit: Long): List<Entry> {
        val startTime = System.currentTimeMillis()
        if (list.isEmpty())
            return emptyList()

        if (list.size == 1)
            return listOf(list[0])

        val pivot = list[list.size / 2]
        val equal = list.filter { it == pivot }
        val less = list.filter { it.name < pivot.name }
        val greater = list.filter { it.name > pivot.name }

        val time = System.currentTimeMillis() - startTime

        if (timeLimit != 0L && time > timeLimit)
            throw RuntimeException("Time exceeded")

        return sort(less, timeLimit - time) + equal + sort(greater, timeLimit - time)
    }
}