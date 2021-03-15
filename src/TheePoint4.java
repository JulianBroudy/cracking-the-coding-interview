import java.util.Stack;

/**
 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes
 * which can slide onto any tower. The puzzle starts with disks sorted in ascending
 * order of size from top to bottom (e.g., each disk sits on top of an even larger one).
 * You have the following constraints:
 * (A) Only one disk can be moved at a time.
 * (B) A disk is slid off the top of one rod onto the next rod.
 * (C) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first rod to the last using Stacks.
 * <p>
 * Created on the 15th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class TheePoint4 {

  public static void main(String[] args) {
    Rod rod1 = new Rod(1);
    Rod rod2 = new Rod(2);
    Rod rod3 = new Rod(3);
    int numberOfDisks = 7;
    for (int i = numberOfDisks; i > 0; i--) {
      rod1.pushDisk(i);
    }
    System.out.println(rod1);
    System.out.println(rod2);
    System.out.println(rod3);
    rod1.moveDisks(rod3, rod2, numberOfDisks);
    System.out.println(rod1);
    System.out.println(rod2);
    System.out.println(rod3);
  }

  static class Rod {

    private int id;
    private Stack<Integer> rod;

    public Rod(int id) {
      this.id = id;
      this.rod = new Stack<>();
    }

    public void pushDisk(int disk) {
      if (rod.isEmpty() || disk < rod.peek()) {
        rod.push(disk);
      } else {
        throw new UnsupportedOperationException("Cannot move disk " + disk);
      }
    }

    public void moveTopDiskTo(Rod destination) {
      final int top = rod.pop();
      destination.pushDisk(top);
    }

    public void moveDisks(Rod destination, Rod buffer, int numberOfDisks) {
      if (numberOfDisks == 0) {
        return;
      }
      moveDisks(buffer, destination, numberOfDisks - 1);
      moveTopDiskTo(destination);
      buffer.moveDisks(destination, this, numberOfDisks - 1);
    }

    @Override
    public String toString() {
      final StringBuilder builder = new StringBuilder("Rod" + id + ":\n");
      final int size = rod.size();
      for (int i = size - 1; i >= 0; i--) {
        builder.append(rod.get(i)).append(",\t");
      }
      return builder.toString();
    }
  }

}
