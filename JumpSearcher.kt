package phonebook

import kotlin.math.sqrt

class JumpSearcher : Searcher {
    override fun search(list: List<Entry>, name: String): Entry? {
        val n = list.size
        var blockSize = sqrt(n.toDouble()).toInt()

        var prev = 0
        while (list[Math.min(blockSize, n) - 1].name < name) {
            prev = blockSize
            blockSize += blockSize
            if (prev >= n)
                return null
        }

        for (i in prev until blockSize.coerceAtMost(n)) {
            if (list[i].name == name)
                return list[i]
        }
        return null
    }
}