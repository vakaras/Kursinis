class Complex(real: Double, imaginary: Double) {
  def re = real
  def im = imaginary
  override def toString() = "" + re + (if (im < 0) "-" else "+") + im + "i"
  }

object ComplexNumbers {
  def main(args: Array[String]) {
    val c = new Complex(1.2, 3.4)
    println("Real part:       " + c.re)
    println("Imaginary part:  " + c.im)
    println("Number:          " + c)
    }
  }
