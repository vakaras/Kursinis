package lt.astrauskas.kursinis.e13


trait Checker extends SourceFile {
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
  def fixExpected(expectedOutput: String) = {
    expectedOutput.replaceAllLiterally("\\\n  ", "")
  }
  def check(expectedOutput: String, output: String): Unit = {
    if (compare(fixExpected(expectedOutput), output)) {
      log("Passed.")
    }
    else {
      log("FAIL.")
      log("----------Expected-----------")
      log(fixExpected(expectedOutput))
      log("------Original expected------")
      log(expectedOutput)
      log("-----------Got---------------")
      log(output)
      log("-----------------------------")
    }
  }
  def log(x: Any): Unit
  def logf(text: String, args: Any*): Unit
}