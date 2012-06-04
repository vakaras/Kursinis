package lt.astrauskas.kursinis.e1
trait T1 {
  def m = List("T1")
}
trait T2 extends T1 {
  override def m = "T2" :: super.m
}
trait T3 extends T2 {
  override def m = "T3" :: super.m
}
trait T4 extends T3 {
  override def m = "T4" :: super.m
}
class C1 extends T4 {
  override def m = "C1" :: super.m
}
trait M3 extends T2 {
  override def m = "M3" :: super.m
}
class C2 extends M3 with T4 {
  override def m = "C2" :: super.m
}
object Demo {
  def main(args: Array[String]): Unit = {
    val o1 = new C1
    println(o1.m)
    val o2 = new C2
    println(o2.m)
  }
}