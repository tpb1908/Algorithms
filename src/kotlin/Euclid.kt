package kotlin

class Euclid {

    companion object {

        fun recursiveEuclid(s: Double, l: Double): Double {
            val min = minOf(l, s)
            val max = maxOf(l, s)
            return if (max%min  == 0.0) min else recursiveEuclid(max%min, min)
        }

        fun iterativeEuclid(s: Double, l: Double): Double {
            var min = minOf(l, s)
            var max = maxOf(l, s)
            while (max%min != 0.0) {
                if (min > max) {
                    val sw = max
                    max = min
                    min = sw
                }
                max %= min
            }
            return min
        }

    }

}