package lt.astrauskas.kursinis.e3

class A {
  class AInner {
    def m = "A.AInner.m()"
    }
  def getInner(): AInner = new AInner()
}

class B extends A {
  class BInner extends AInner {
    override def m = "B.BInner.m()"
  }
  override def getInner(): BInner = new BInner()
}

object Demo {

  def main(args: Array[String]): Unit = {
    val a: A = new A()
    val aInner: A#AInner = a.getInner()
    println(aInner.m)
    val b: A = new B()
    val bInner: A#AInner = b.getInner()
    println(bInner.m)
  }

}