import java.util.HashSet;
import utils.MyLinkedList;

/**
 * Given a circular linked list, find an algorithm which returns node at the beginning of the loop.
 * DEFINITION: Circular linked list: A (corrupt) linked list in which a node’s next pointer points
 * to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 * <p>
 * Created on the 12th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class TwoPoint5 {

  public static void main(String[] args) {
    MyLinkedList circular = new MyLinkedList(1);
    circular.append(2);
    circular.append(3);
    circular.append(4);
    circular.append(5);
    circular.append(circular.getNodeAt(2));

    MyLinkedList loopStartNode = findLoopStart(circular);
    System.out.println(loopStartNode);
  }

  // With extra space
  private static MyLinkedList findLoopStart(MyLinkedList circular) {
    final HashSet<MyLinkedList> set = new HashSet<>();
    MyLinkedList runner = circular;
    while (runner != null) {
      if(set.contains(runner)){
        return runner;
      }
      set.add(runner);
      runner = runner.next;
    }
    return new MyLinkedList("No Loop");
  }


}
