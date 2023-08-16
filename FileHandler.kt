package phonebook

import java.io.File

class FileHandler {
    companion object {
        fun readEntries(filename: String): List<Entry> {
            val entries = mutableListOf<Entry>()
            File(filename).forEachLine {
                val (number, name) = it.split(Regex(" "), 2)
                entries.add(Entry(number, name))
            }
            return entries
        }

        fun readNames(filename: String): List<String> {
            val names = mutableListOf<String>()
            File(filename).forEachLine { names.add(it) }
            return names
        }
    }
}