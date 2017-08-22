package kotlin

class BinarySearch {

    companion object {

        fun<T : Comparable<T>> search(data: Array<T>, item: T): Int {
            var left = 0
            var right = data.size - 1
            var current: Int
            do {
                current = right+left / 2
                when {
                    data[current] < item -> left = current + 1
                    data[current] > item -> right = current - 1
                    else -> return current
                }
            } while (right >= 1)
            return -1
        }

    }

}