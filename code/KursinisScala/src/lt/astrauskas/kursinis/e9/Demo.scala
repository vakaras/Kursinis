package lt.astrauskas.kursinis.e9

object Demo {
  def main(args: Array[String]): Unit = {
    val langelis = new SveikųjųSkaičiųLangelis(4)
    val skaičius: Integer = langelis.gautiReikšmę()
//    val eilutė: String = langelis.gautiReikšmę()
                                        // Kompiliavimo klaida.
    }
  }