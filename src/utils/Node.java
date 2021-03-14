package utils;

/**
 * TODO provide a summary to Node class!!!!!
 * <p>
 * Created on the 12th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class Node<T> {
  public Node<T> next;
  public T data;

  public Node() {
  }

  public Node(T data) {
    this.data = data;
    this.next = null;
  }

  @Override
  public String toString() {
    return "data=" + data + "  next=" + (next == null ? "null" : next.data);
  }
}
