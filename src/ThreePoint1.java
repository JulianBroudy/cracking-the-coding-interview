/**
 * Describe how you could use a single array to implement three stacks.
 * <p>
 * Created on the 12th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class ThreePoint1 {

  static class ArrayStack {

    final int stackSize = 100;
    final int[] stacks = new int[stackSize * 3 - 1];
    final int[] topPointers = new int[]{0, 0, 0};

    public int pop(int stackNumber) {
      if (isEmpty(stackNumber)) {
        throw new IndexOutOfBoundsException();
        //  indicating error
      }
      final int index = stackSize * stackNumber + topPointers[stackNumber];
      topPointers[stackNumber]--;
      int toPop = stacks[index];
      stacks[index] = 0;
      return toPop;
    }

    public void push(int stackNumber, int data) {
      final int index = stackSize * stackNumber + topPointers[stackNumber] + 1;
      if (index > stackNumber * stackSize) {
        throw new IndexOutOfBoundsException();
      }
      topPointers[stackNumber]++;
      stacks[index] = data;
    }

    public boolean isEmpty(int stackNumber) {
      return topPointers[stackNumber] == stackNumber * stackSize;
    }
  }

}
