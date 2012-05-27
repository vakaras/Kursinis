package lt.astrauskas.kursinis.e7

abstract class SubjectObserver {
  type S <: Subject
  type O <: Observer
  abstract class Subject {
    private var observers: List[O] = List()
    def subscribe(obs: O) = observers = obs :: observers
    def publish = for (val obs <- observers) obs.notify(self)
    def self: S = this.asInstanceOf[S]
    }
  abstract class Observer {
    def notify(sub: S): Unit
    }
  }

object SensorReader extends SubjectObserver {
  type S = Sensor
  type O = Display
  abstract class Sensor extends Subject {
    val label: String
    var value: Double = 0.0
    def changeValue(v: Double) = {
      value = v
      publish
      }
    }
  class Display(val name: String) extends Observer {
    def show(msg: String) = println(name + ": " + msg)
    def notify(sub: Sensor) = show(sub.label + " has value " + sub.value)
    }
  }

object Demo {
  import SensorReader._;
  val s1 = new Sensor { val label = "sensor1" }
  val s2 = new Sensor { val label = "sensor2" }
  def main(args: Array[String]): Unit = {
    val d1 = new Display("display1")
    val d2 = new Display("display2")
    s1.subscribe(d1)
    s1.subscribe(d2)
    s2.subscribe(d1)
    s1.changeValue(2)
    s2.changeValue(3)
  }
}
