package lt.astrauskas.kursinis.e11

import scala.collection.mutable.ListBuffer

class AbstractTree {
  type Node <: BaseNode
  trait BaseNode {
    this: Node =>                       // Savojo tipo anotacija.
    private val children = new ListBuffer[BaseNode]
    def walk(show: Node => Unit): Unit = {
      show(this)                        // this tipas yra Node.
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
    var root = new tree.SimpleNode("Root")
                                        // root tipas yra tree.SimpleNode.
    root.addChild(new tree.SimpleNode("First child"))
    root.addChild(new tree.SimpleNode("Second child"))
    root.walk((n: tree.SimpleNode) => println(n.name))
    val tree2 = new Tree()
    root = new tree.SimpleNode("Root2")
//    root = new tree2.SimpleNode("Root3")
                                        // Kompiliavimo klaida.
    var node: Tree#SimpleNode = new tree.SimpleNode("Node1")
    node = new tree2.SimpleNode("Node2")
  }

}