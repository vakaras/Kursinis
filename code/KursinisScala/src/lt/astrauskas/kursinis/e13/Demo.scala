package lt.astrauskas.kursinis.e13

import java.io.FileReader


object Demo {
  def testFile(filename: String) = {
    val outputStream = new ClearableOutputStream()
    Console.withOut(outputStream) {
      val test = new DocTest(new FileReader(filename), outputStream)
      test()
    }
  }
  def main(args: Array[String]): Unit = {
    for (filename <- args) {
      println("Testing file: " + filename)
      testFile(filename)
    }
  }
}