package lt.astrauskas.kursinis.e2;

public class A {

  public class AInner {

    public String m() {
      return "A.AInner.m()";
    }

  }

  public AInner getInner() {
    return new AInner();
  }

}
