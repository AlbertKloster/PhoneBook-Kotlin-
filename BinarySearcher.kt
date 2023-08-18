package phonebook

class BinarySearcher : Searcher {
    override fun search(list: List<Entry>, name: String): Entry? {
        var left = 0
        var right = list.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            when {
                list[mid].name == name -> return list[mid]
                list[mid].name < name -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return null
    }
}