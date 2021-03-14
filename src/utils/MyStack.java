package utils;

/**
 * Stack class.
 * <p>
 * Created on the 11th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class MyStack<T> extends Node<T> {

  private final int maxSize;
  public Node<T> top;
  private int size;

  public MyStack() {
    this(Integer.MAX_VALUE);
  }

  public MyStack(int size) {
    this.size = 0;
    this.maxSize = size;
  }

  public Node<T> pop() {
    if (top != null) {
      Node<T> toPop = top;
      top = top.next;
      size--;
      return toPop;
    }
    return null;
  }

  public void push(Node<T> node) {
    if (isFull()) {
      throw new OutOfMemoryError("Stack is full");
    }
    node.next = top;
    top = node;
    size++;
  }

  public Node<T> peek() {
    return top;
  }

  public void push(T data) {
    push(new Node<>(data));
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == maxSize;
  }

  public void printStack() {
    Node<T> node = top;
    while (node != null) {
      System.out.print(node + ", ");
      node = node.next;
    }
  }

}
