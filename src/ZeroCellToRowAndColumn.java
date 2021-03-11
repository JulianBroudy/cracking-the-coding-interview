import java.util.ArrayList;
import java.util.List;
import utils.Printer;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column is set to 0.
 * <p>
 * Created on the 11th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class ZeroCellToRowAndColumn {

  public static void main(String[] args) {
    final int[][] matrix = new int[][]{{0, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 1, 1}};
    Printer.printMatrix(matrix);
    processMatrix(matrix);
    System.out.println();
    Printer.printMatrix(matrix);
  }

  private static void processMatrix(int[][] matrix) {
    final int numberOfRows = matrix.length;
    final int numberOfColumns = matrix[0].length;

    List<Integer> rowsToNullify = new ArrayList<>();
    List<Integer> colsToNullify = new ArrayList<>();

    for (int row = 0; row < numberOfRows; row++) {
      for (int col = 0; col < numberOfColumns; col++) {
        if (matrix[row][col] == 0) {
          rowsToNullify.add(row);
          colsToNullify.add(col);
        }
      }
    }

    for (int row : rowsToNullify) {
      matrix[row] = new int[numberOfColumns];
    }
    for (int col : colsToNullify) {
      for (int row = 0; row < numberOfRows; row++) {
        matrix[row][col] = 0;
      }
    }
  }

}
