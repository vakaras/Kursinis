package lt.astrauskas.kursinis.e13

trait Logger extends SourceFile {
  def out = java.lang.System.out
  def log(x: Any): Unit = {
    out.println(x)
  }
  def logf(text: String, args: Any*): Unit = {
    out.print(text format (args : _*))
  }
}