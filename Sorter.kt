package phonebook

interface Sorter {
    fun sort(list: List<Entry>, timeLimit: Long = 0): List<Entry>
}