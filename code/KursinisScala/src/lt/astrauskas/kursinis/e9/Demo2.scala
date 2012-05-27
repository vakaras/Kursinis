package lt.astrauskas.kursinis.e9

class SkaičiųLangelis2(val numatytojiReikšmė: Number) {
  private var reikšmė: Number = numatytojiReikšmė
  def nustatytiReikšmę(naujaReikšmė: Number) = reikšmė = naujaReikšmė
  def gautiReikšmę() = reikšmė
  }

object Demo2 {
  def main(args: Array[String]): Unit = {
    val langelis = new SkaičiųLangelis2(4)
    val skaičius: Integer = langelis.gautiReikšmę().asInstanceOf[Integer]
    val eilutė: String = langelis.gautiReikšmę().asInstanceOf[String]
                                    // Klaida vykdymo metu.
    }
  }
