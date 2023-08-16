package phonebook

import phonebook.Constants.Companion.DIRECTORY

class DatabaseService {

    private val database = Database(DIRECTORY)

    fun findAllEntriesForNames(names: List<String>) = database.getAllEntriesForNames(names)

}