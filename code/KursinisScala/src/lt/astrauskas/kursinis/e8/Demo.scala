package lt.astrauskas.kursinis.e8

trait Family {

  type M <: Mother
  type F <: Father
  type C <: Child

  class Father (val name: String) {
    def kiss(m:M) = println( "Showing signs of affection towards " + m.name)
    }
  class Mother (val name: String)
  class Child (val name: String) {
    def askForhelp (m:M) = println( "Screeaaaaming at " + m.name)
    }
  }

object UpperClassFamily extends Family {
  type F = Father
  type M = Mother
  type C = PoliteChild

  class Mother (name: String , val lastName: String)
    extends super.Mother(name)
  class PoliteChild(name: String) extends Child (name) {
    override def askForhelp (m:M) = {
      println("Asking " + m.name + m. lastName + " for help " )
    }
  }
}

object StandardFamily extends Family {
  type F = Father
  type M = Mother
  type C = Child
  }

object Demo {

  def main(args: Array[String]): Unit = {
    val father: Family#Father = new StandardFamily.Father("John")
    val mother: Family#Mother = new StandardFamily.Mother("Maria")
    //father.kiss(mother)
    val upperClassMother: Family#Mother =
      new UpperClassFamily. Mother("Dorthea", "III")
    //father.kiss( upperClassMother )
  }

}