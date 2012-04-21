package lt.astrauskas.kursinis.e2;

public class Demo {

  public static void main(String[] args) {
    A a = new A();
    A.AInner aInner = a.getInner();
    System.out.println(aInner.m());
    A b = new B();
    A.AInner bInner = b.getInner();
    System.out.println(bInner.m());
  }

}
