package lt.astrauskas.kursinis.e12

import scala.tools.nsc.interpreter.ILoop
import scala.tools.nsc.Settings
import java.io.{
  Reader, BufferedReader, PrintWriter, FileReader, PrintStream}


class PrintingReader(reader: Reader, val writer: PrintWriter)
    extends BufferedReader(reader) {
  override def readLine(): String = {
    val line = super.readLine()
    if (line != null) {
      writer.write(line)
      writer.write('\n')
      writer.flush()
    }
    return line
  }
}


class DocGenerator(val reader: Reader, val writer: PrintWriter) {
  def this(inputFile: String, outputFile: String) = {
    this(new FileReader(inputFile), new PrintWriter(outputFile))
  }
  def this(inputFile: String) = {
    this(new FileReader(inputFile), new PrintWriter(Console.out, true))
  }
  def this(reader: Reader) = {
    this(reader, new PrintWriter(Console.out, true))
  }
  def apply() {
    val printingReader = new PrintingReader(
        new BufferedReader(reader), writer)
    val settings = new Settings()
    new ILoop(printingReader, writer) process settings
  }
}


object Demo {
  def main(args: Array[String]): Unit = {
    val reader = new FileReader("test.scala")
    val output = new PrintStream("test.out.scala")
    val writer = new PrintWriter(output)
    Console.setOut(output)
    val generator = new DocGenerator(reader, writer)
    generator()
    }
  }
