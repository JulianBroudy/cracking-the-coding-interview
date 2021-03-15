import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * <p>
 * Created on the 15th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class ThreePoint4 {


  public static void main(String[] args) {
    StacksQueue queue = new StacksQueue();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.printStacks();
    queue.dequeue();
    queue.dequeue();
    queue.printStacks();
  }

  static class StacksQueue {

    Stack<Integer>[] twoStacks = new Stack[2];

    public StacksQueue() {
      twoStacks[0] = new Stack<>();
      twoStacks[1] = new Stack<>();
    }

    public void enqueue(int data) {
      twoStacks[0].push(data);
    }

    public int dequeue() {
      final int size = twoStacks[0].size() - 1;
      for (int i = 0; i < size; i++) {
        twoStacks[1].push(twoStacks[0].pop());
      }
      int res = twoStacks[0].pop();
      for (int i = 0; i < size; i++) {
        twoStacks[0].push(twoStacks[1].pop());
      }
      return res;
    }

    public void printStacks() {
      System.out.println();
      final int size = twoStacks[0].size() - 1;
      for (int i = size; i >= 0; i--) {
        System.out.print(twoStacks[0].get(i) + ",\t");
      }
    }


  }


}
