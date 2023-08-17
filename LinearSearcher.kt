package phonebook

class LinearSearcher : Searcher {
    override fun search(list: List<Entry>, name: String): Entry? {
        for (entry in list) {
            if (entry.name == name)
                return entry
        }
        return null
    }

}