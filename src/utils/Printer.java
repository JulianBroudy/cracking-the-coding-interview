package utils;

import java.util.Arrays;

/**
 * A helper class.
 * <p>
 * Created on the 11th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class Printer {

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

}
