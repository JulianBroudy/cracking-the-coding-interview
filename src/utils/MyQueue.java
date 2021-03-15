package utils;

/**
 * Queue class.
 * <p>
 * Created on the 15th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class MyQueue<T> {

  Node<T> first;
  Node<T> last;

  public void enqueue(Node<T> node) {
    if (first == null) {
      first = node;
      last = node;
    } else {
      last.next = node;
      last = node;
    }
  }

  public Node<T> dequeue() {
    Node<T> result = first;
    if (first.next != null) {
      first = first.next;
    } else {
      first = null;
      last = null;
    }
    return result;
  }

  public void printQueue() {
    Node<T> runner = first;
    System.out.println();
    while (runner != null) {
      System.out.print(runner + "==>\t");
      runner = runner.next;
    }
    System.out.println();
  }
}
