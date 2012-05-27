package lt.astrauskas.kursinis.e11

import scala.collection.mutable.ListBuffer

class AbstractTree {
  type Node <: BaseNode
  trait BaseNode {
    this: Node =>                       // Savojo tipo anotacija.
    private val children = new ListBuffer[BaseNode]
    def walk(show: Node => Unit): Unit = {
      show(this)
      for (node <- children)
        node.walk(show)
    }
    def addChild(child: BaseNode) = children += child
  }
}

class Tree extends AbstractTree {
  type Node = SimpleNode
  class SimpleNode(val name: String) extends BaseNode {}
}

object Demo {

  def main(args: Array[String]): Unit = {
    val tree = new Tree()
    val root = new tree.SimpleNode("Root")
    root.addChild(new tree.SimpleNode("First child"))
    root.addChild(new tree.SimpleNode("Second child"))
    root.walk((n: tree.SimpleNode) => println(n.name))
  }

}