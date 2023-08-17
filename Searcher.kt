package phonebook

interface Searcher {
    fun search(list: List<Entry>, name: String): Entry?
}