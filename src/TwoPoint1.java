import java.util.HashSet;
import utils.MyLinkedList;
import utils.Utils;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * <p>
 * Created on the 11th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class TwoPoint1 {

  public static void main(String[] args) {
    MyLinkedList head = new MyLinkedList(1);
    head.append(1);
    head.append(3);
    head.append(1);
    Utils.printList(head);
    // removeDuplicates(head);
    removeDuplicates2(head);
    Utils.printList(head);
  }

  // No buffer
  private static void removeDuplicates2(MyLinkedList head) {
    MyLinkedList current = head;
    while (current != null && current.next != null) {
      MyLinkedList prev = current;
      MyLinkedList runner = current.next;
      while (runner != null) {
        if (runner.data == current.data) {
          prev.next = runner.next;
        } else {
          prev = runner;
        }
        runner = runner.next;
      }
      current = current.next;
    }
  }

  private static void removeDuplicates(MyLinkedList head) {
    if (head == null) {
      return;
    }
    final HashSet<Object> hashSet = new HashSet<>();
    MyLinkedList node = head;
    hashSet.add(node.data);
    while (node.next != null) {
      if (hashSet.contains(node.next.data)) {
        node.next = node.next.next;
      } else {
        hashSet.add(node.next.data);
        node = node.next;
      }
    }
  }

}
