package phonebook

class Database(filename: String) {
    private val data = FileHandler.readEntries(filename)

    fun getAllEntriesForNames(names: List<String>) = data.filter { it.name in names }

}