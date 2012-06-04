package lt.astrauskas.kursinis.e13

import java.io.{BufferedReader, Reader}
import scala.collection.mutable.ListBuffer


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