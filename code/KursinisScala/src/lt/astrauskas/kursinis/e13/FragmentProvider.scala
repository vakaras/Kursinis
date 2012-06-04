package lt.astrauskas.kursinis.e13


trait FragmentProvider extends SourceFile {
  val fragments : Iterable[Fragment]
  var currentFragment: Fragment = null
  val outputStream: ClearableOutputStream
  lazy val fragmentIterator = fragments.iterator

  def check(expectedOutput: String, output: String): Unit

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
        check(currentFragment.output.toString(), outputStream.get())
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