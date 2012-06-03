scala> import lt.astrauskas.kursinis.e11._
import lt.astrauskas.kursinis.e11._

scala> val tree = new Tree()
tree: lt.astrauskas.kursinis.e11.Tree = \
  lt.astrauskas.kursinis.e11.Tree@????????

scala> var root = new tree.SimpleNode("Root")
root: tree.SimpleNode = lt.astrauskas.kursinis.e11.Tree$SimpleNode@???????

scala> // root tipas yra tree.SimpleNode.

scala> root.addChild(new tree.SimpleNode("First child"))

scala> root.addChild(new tree.SimpleNode("Second child"))

scala> root.walk((n: tree.SimpleNode) => println(n.name))
Root
First child
Second child

scala> val tree2 = new Tree()
tree2: lt.astrauskas.kursinis.e11.Tree = \
  lt.astrauskas.kursinis.e11.Tree@????????

scala> root = new tree.SimpleNode("Root2")
root: tree.SimpleNode = lt.astrauskas.kursinis.e11.Tree$SimpleNode@????????

scala> root = new tree2.SimpleNode("Root3")
<console>:13: error: type mismatch;
 found   : tree2.SimpleNode
 required: tree.SimpleNode
       root = new tree2.SimpleNode("Root3")
              ^

scala> var node: Tree#SimpleNode = new tree.SimpleNode("Node1")
node: lt.astrauskas.kursinis.e11.Tree#SimpleNode = \
  lt.astrauskas.kursinis.e11.Tree$SimpleNode@????????

scala> node = new tree2.SimpleNode("Node2")
node: lt.astrauskas.kursinis.e11.Tree#SimpleNode = \
  lt.astrauskas.kursinis.e11.Tree$SimpleNode@????????

