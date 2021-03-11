package utils;

/**
 * TODO provide a summary to utils.MyLinkedList class!!!!!
 * <p>
 * Created on the 11th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class MyLinkedList {

  public MyLinkedList next;
  public Object data;

  public MyLinkedList(Object data) {
    this.next = null;
    this.data = data;
  }

  public void append(Object data) {
    final MyLinkedList newNode = new MyLinkedList(data);
    MyLinkedList node = this;
    while (node.next != null) {
      node = node.next;
    }
    node.next = newNode;
  }



}
