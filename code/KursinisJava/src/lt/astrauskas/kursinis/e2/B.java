package lt.astrauskas.kursinis.e2;

public class B extends A {

  public class BInner extends AInner {

    public String m() {
      return "B.BInner.m()";
    }

  }

  public BInner getInner() {
    return new BInner();
  }

}
