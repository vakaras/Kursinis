scala> import lt.astrauskas.kursinis.e10.CachedFactorial
import lt.astrauskas.kursinis.e10.CachedFactorial

scala> val cf = new CachedFactorial()
cf: lt.astrauskas.kursinis.e10.CachedFactorial = \
  lt.astrauskas.kursinis.e10.CachedFactorial@????????

scala> println("3! = " + cf.lookup(3))
Calculating 3
Calculating 2
Calculating 1
3! = 6

scala> println("5! = " + cf.lookup(5))
Calculating 5
Calculating 4
5! = 120

