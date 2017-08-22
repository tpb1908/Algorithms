package kotlin

class BinPacker {

    companion object {

        fun pack(binSize: Int, binCount: Int, items: IntArray): IntArray {
            val bins = IntArray(binCount)
            items.sortDescending()
            items.forEach {
                bins.forEachIndexed { index, i ->
                    if (i + it < binSize) {
                        bins[index] += it
                        return@forEachIndexed
                    }
                }
            }
            return bins
        }
    }

}