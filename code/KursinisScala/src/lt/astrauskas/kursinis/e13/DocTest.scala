package lt.astrauskas.kursinis.e13


import java.io.Reader
import java.io.PrintWriter
import scala.tools.nsc.Settings
import scala.tools.nsc.interpreter.ILoop


class DocTest(
    val reader: Reader,
    val output: ClearableOutputStream) {

  def apply() {
    val sourceFile = new SourceFile(reader)
      with FragmentProvider
      with Logger
      with Checker {val outputStream = output}
    val settings = new Settings()
    new ILoop(sourceFile, new PrintWriter(output)) process settings
  }
}