package utils;

/**
 * LinkedList class.
 * <p>
 * Created on the 11th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class MyLinkedList {

  public MyLinkedList next;
  public Object data;
  private int size;

  public MyLinkedList(Object data) {
    this.next = null;
    this.data = data;
    this.size = 1;
  }

  public void append(Object data) {
    final MyLinkedList newNode = new MyLinkedList(data);
    MyLinkedList node = this;
    while (node.next != null) {
      node = node.next;
    }
    node.next = newNode;
    this.size++;
  }

  public void append(MyLinkedList node) {
    MyLinkedList runner = this;
    while (runner.next != null) {
      runner = runner.next;
    }
    runner.next = node;
    this.size++;
  }

  public MyLinkedList getNodeAt(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }
    MyLinkedList node = this;
    int position = 0;
    while (node.next != null && position != index) {
      node = node.next;
      position++;
    }
    return node;
  }

  @Override
  public String toString() {
    return "data=" + data + "  next=" + (next == null ? "null" : next.data);
  }
}
