package utils;

import java.util.Arrays;

/**
 * A helper class.
 * <p>
 * Created on the 11th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class Utils {

  public static <T> void  printMatrix(T[][] matrix) {
    for (T[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static void  printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static void printList(MyLinkedList head){
    if (head == null) {
      System.out.println("Empty");
    }
    MyLinkedList node = head;
    while (node != null) {
      System.out.print(node.data);
      node = node.next;
    }
    System.out.println();
  }

  // Taken from Geeks4Geeks
  public static int isSubstring(String string, String substring)
  {

    int t = 0;
    int len = string.length();
    int i;

    // Iterate from 0 to len - 1
    for (i = 0; i < len; i++) {
      if (t == substring.length())
        break;
      if (string.charAt(i) == substring.charAt(t))
        t++;
      else
        t = 0;
    }

    return t < substring.length() ? -1 : i - t;
  }

}
