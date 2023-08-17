package phonebook

class Database(filename: String) {
    val data = FileHandler.readEntries(filename)
}