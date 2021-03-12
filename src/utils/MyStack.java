package utils;

/**
 * Stack class.
 * <p>
 * Created on the 11th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class MyStack {

  public Node top;
  private int size;

  public MyStack() {
    this.size = 0;
  }

  public Node pop() {
    if (top != null) {
      Node toPop = top;
      top = top.next;
      return toPop;
    }
    return null;
  }

  public void push(Node node) {
    node.next = top;
    top = node;
  }

  public void push(Object data) {
    final Node toPush = new Node(data);
    toPush.next = top;
    top = toPush;
  }

  static class Node {

    public Node next;
    public Object data;

    public Node(Object data) {
      this.data = data;
      this.next = null;
    }

  }
}
