package lt.astrauskas.kursinis.e13


trait Checker extends SourceFile {
  def compare(expected: String, got: String): Boolean = {
    val expectedLines = expected.split("\n")
    val gotLines = got.split("\n")
    if (expectedLines.length != gotLines.length) {
      return false
    }
    else {
      for ((expectedLine, gotLine) <- expectedLines.zip(gotLines)) {
        if ((expectedLine.endsWith("..."))) {
          val checkedLength = expectedLine.length() - 3
          if (checkedLength > gotLine.length()) {
            return false
          }
          else {
            for (i <- 0.to(checkedLength-1)) {
              if ((expectedLine(i) != '?') &&
                  (expectedLine(i) != gotLine(i))) {
                return false
              }
            }
          }
        }
        else {
          if (expectedLine.length() != gotLine.length()) {
            return false
          }
          else {
            for ((e, g) <- expectedLine.zip(gotLine)) {
              if ((e != '?') && (e != g)) {
                return false
              }
            }
          }
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
      log("------Original expected------")
      log(expectedOutput)
      log("----------Expected-----------")
      log(fixExpected(expectedOutput))
      log("-----------Got---------------")
      log(output)
      log("-----------------------------")
    }
  }
  def log(x: Any): Unit
  def logf(text: String, args: Any*): Unit
}