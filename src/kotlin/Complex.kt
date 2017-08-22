package kotlin

class Complex(var a: Double, var b: Double): Number() {

    override fun toByte(): Byte {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toChar(): Char {
        return Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0)).toChar()
    }

    override fun toDouble(): Double {
        return Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0))
    }

    override fun toFloat(): Float {
        return Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0)).toFloat()
    }

    override fun toInt(): Int {
        return Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0)).toInt()
    }

    override fun toLong(): Long {
        return Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0)).toLong()
    }

    override fun toShort(): Short {
        return Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0)).toShort()
    }

    operator fun Complex.minus(c: Complex): Complex = Complex(a - c.a, b - c.b)

    operator fun Complex.plus(c: Complex): Complex = Complex(a + c.a, b + c.b)

    operator fun Complex.times(c: Complex): Complex = Complex(a * c.a - b * c.b, a * c.a + b * c.b)

    operator fun Complex.div(c: Complex): Complex {
        return Complex(
                (a * c.a + b * c.b) / (c.a * c.a  + c.b * c.b),
                (b * c.a - a * c.b) / (c.a * c.a  + c.b * c.b)
        )
    }

    override fun equals(other: Any?): Boolean {
        return other is Complex && other.a == a && other.b == b
    }
}