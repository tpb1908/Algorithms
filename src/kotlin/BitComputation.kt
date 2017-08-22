package kotlin


class BitComputation {

    companion object {

        fun isEven(num: Long): Boolean {
            return (num.and(0x000000001)) == 0L
        }

        fun isSet(num: Long, n: Int): Boolean {
            return num.or(1L.shl(n)) == num
        }

        fun setNthBit(num: Long, n: Int): Long {
            return num.or(1L.shl(n))
        }

        fun unsetNthBit(num: Long, n: Int): Long {
            return num.and(1L.shl(n).inv())
        }

        fun toggleNthBit(num: Long, n: Int): Long {
            return num.xor(1L.shl(n))
        }

        //https://stackoverflow.com/a/109025/4191572
        fun countTrue(num: Long): Int {
            var wtf = num - ((num.shr(1)).and(0x55555555))
            wtf = wtf.and(0x33333333) + (wtf.shr(2).and(0x33333333))
            return ((wtf + (wtf.shr(4).and(0x0F0F0F0F) * 0x01010101))).shr(24).toInt()
        }



    }

}
