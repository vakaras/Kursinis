package lt.astrauskas.kursinis.e13

import java.io.OutputStream


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