import java.util.LinkedList;
import utils.MyStack;
import utils.Node;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in
 * real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of
 * several stacks, and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is,
 * pop() should return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 * <p>
 * Created on the 12th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class ThreePoint3 {

  public static void main(String[] args) {
    SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(2);
    setOfStacks.push(1);
    setOfStacks.push(2);
    setOfStacks.push(3);
    setOfStacks.push(4);
    setOfStacks.push(5);
    setOfStacks.printStacks();
    System.out.println("popped");
    setOfStacks.pop();
    setOfStacks.pop();
    setOfStacks.printStacks();
  }

  // Many ways to implement: using arraylist, stack, ...
  static class SetOfStacks<T> {

    final LinkedList<MyStack<T>> stacksList = new LinkedList<>();
    final int stackSize;
    MyStack<T> currentStack;

    public SetOfStacks(int stackSize) {
      this.stackSize = stackSize;
      this.currentStack = new MyStack<>(stackSize);
      stacksList.addLast(currentStack);
    }

    public Node<T> pop() {
      if (currentStack == null) {
        throw new IndexOutOfBoundsException();
      }
      Node<T> result = currentStack.pop();
      if (currentStack.isEmpty() && stacksList.size() != 1) {
        stacksList.removeLast();
        currentStack = stacksList.getLast();
      }
      return result;
    }

    public void push(T data) {
      push(new Node<>(data));
    }

    public void push(Node<T> node) {
      if (currentStack.isFull()) {
        currentStack = new MyStack<>(stackSize);
        stacksList.addLast(currentStack);
      }
      currentStack.push(node);
    }

    public void printStacks() {
      for (MyStack<T> stack : stacksList) {
        System.out.println();
        stack.printStack();
      }

    }

  }

}
