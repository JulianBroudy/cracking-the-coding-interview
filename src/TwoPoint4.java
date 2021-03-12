import utils.MyLinkedList;
import utils.Utils;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 * <p>
 * Created on the 12th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class TwoPoint4 {

  public static void main(String[] args) {
    MyLinkedList l1 = new MyLinkedList(3);
    l1.append(1);
    l1.append(5);
    MyLinkedList l2 = new MyLinkedList(5);
    l2.append(9);
    l2.append(0);
    Utils.printList(l1);
    Utils.printList(l2);
    MyLinkedList res = addLists(l1, l2);
    Utils.printList(res);
  }

  private static MyLinkedList addLists(MyLinkedList l1, MyLinkedList l2) {
    if (l1 == null && l2 == null) {
      return new MyLinkedList(0);
    }

    MyLinkedList l1h = l1, l2h = l2;
    MyLinkedList head = new MyLinkedList(0);
    MyLinkedList result = head;
    int carry = 0;
    int sum;
    while (l1h != null || l2h != null || carry != 0) {
      sum = carry + (l1h == null ? 0 : (int) l1h.data) + (l2h == null ? 0 : (int) l2h.data);
      if (sum > 9) {
        carry = sum / 10;
        sum = sum % 10;
      } else {
        carry = 0;
      }
      result.next = new MyLinkedList(sum);
      result = result.next;
      if (l1h != null) {
        l1h = l1h.next;
      }
      if (l2h != null) {
        l2h = l2h.next;
      }
    }
    return head.next;
  }

  // Fixed solution from book
  static MyLinkedList addLists(MyLinkedList l1, MyLinkedList l2, int carry) {
    if (l1 == null && l2 == null) {
      return null;
    }
    MyLinkedList result = new MyLinkedList(0);
    int value = carry;
    if (l1 != null) {
      value += (int) l1.data;
    }
    if (l2 != null) {
      value += (int) l2.data;
    }
    result.data = value % 10;
    MyLinkedList more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
        value > 9 ? 1 : 0);
    result.next = more;
    return result;
  }
}
