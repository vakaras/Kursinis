package lt.astrauskas.kursinis.e13


import java.io.BufferedReader
import java.io.Reader
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Queue
import java.io.FileReader
import java.io.Writer
import java.io.OutputStream
import java.nio.ByteBuffer
import scala.tools.nsc.Settings
import scala.tools.nsc.interpreter.ILoop
import java.io.PrintWriter
import scala.util.DynamicVariable
import java.io.PrintStream

class Fragment {
  val input = new Queue[String]
  val output = new StringBuffer()
  var check = true
}

class SourceFile(val reader: Reader) extends BufferedReader(reader) {

  val fragments = new ListBuffer[Fragment]()
  val prompt =              "scala> "
  val continuationPrompt =  "     | "

  readFile()

  private def readFile() = {
    val cpFragment = new Fragment()
    cpFragment.input += ":cp code/KursinisScala/bin"
    cpFragment.check = false
    fragments += cpFragment
    var line = super.readLine()
    var currentFragment: Fragment = null
    while (line != null) {
      if (line.startsWith(prompt)) {
        if (currentFragment != null) {
          fragments += currentFragment
        }
        currentFragment = new Fragment()
        currentFragment.input += line.stripPrefix(prompt)
      }
      else if (line.startsWith(continuationPrompt)) {
        currentFragment.input += line.stripPrefix(continuationPrompt)
      }
      else {
        currentFragment.output.append(line)
        currentFragment.output.append('\n')
      }
      line = super.readLine()
    }
    if (currentFragment != null) {
      fragments += currentFragment
    }
  }
}

trait FragmentProvider extends SourceFile {
  val fragments : Iterable[Fragment]
  var currentFragment: Fragment = null
  val outputStream: ClearableOutputStream
  lazy val fragmentIterator = fragments.iterator

  def check(expectedOutput: String): Unit

  def quit() = ":quit"

  override def readLine(): String = {
    var first = false
    if (currentFragment == null) {
      first = true
      outputStream.clear()
      if (fragmentIterator.hasNext) {
        currentFragment = fragmentIterator.next()
      }
      else {
        return quit()
      }
    }
    if (currentFragment.input.isEmpty) {
      outputStream.remove(prompt.length())
      if (currentFragment.check) {
        check(currentFragment.output.toString())
      }
      outputStream.clear()
      if (fragmentIterator.hasNext) {
        currentFragment = fragmentIterator.next()
      }
      else {
        return quit()
      }
    }
    else {
      if (!first) {
        outputStream.remove(continuationPrompt.length())
        }
    }
    return currentFragment.input.dequeue()
  }
}

trait Checker extends SourceFile {
  val outputStream: ClearableOutputStream
  def compare(expected: String, got: String): Boolean = {
    if (expected.length() != got.length()) {
      return false
    }
    else {
      for ((e, g) <- expected.zip(got)) {
        if ((e != '?') && (e != g)) {
          return false
        }
      }
      return true
    }
  }
  def check(expectedOutput: String): Unit = {
    val output = outputStream.get()
    if (compare(expectedOutput, output)) {
      log("Passed.")
    }
    else {
      log("FAIL.")
      log("----------Expected-----------")
      log(expectedOutput)
      log("-----------Got---------------")
      log(output)
      log("-----------------------------")
    }
  }
  def log(x: Any): Unit
  def logf(text: String, args: Any*): Unit
}

trait Logger extends SourceFile {
  def out = java.lang.System.out
  def log(x: Any): Unit = {
    out.println(x)
  }
  def logf(text: String, args: Any*): Unit = {
    out.print(text format (args : _*))
  }
}

class ClearableOutputStream extends OutputStream {
  val buffer = new StringBuffer()
  def write(byte: Int) = {
    buffer.append(byte.asInstanceOf[Char])
  }
  def clear() = {
    buffer.delete(0, buffer.length())
  }
  def remove(count: Int) = {
    buffer.delete(buffer.length()-count, buffer.length())
  }
  def get() = {
    buffer.toString()
  }
}

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