import utils.Utils;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
 * method to rotate the image by 90 degrees. Can you do this in place?
 * <p>
 * Created on the 11th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class OnePoint6 {

  public static void main(String[] args) {
    // final int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    final int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
        {13, 14, 15, 16}};
    Utils.printMatrix(matrix);
    rotateMatrix(matrix);
    System.out.println();
    Utils.printMatrix(matrix);
  }

  static void rotateMatrix(int[][] matrix) {
    final int dimension = matrix.length;
    final int numberOfLayers = dimension / 2;

    for (int layer = 0; layer < numberOfLayers; layer++) {
      final int first = layer;
      final int last = dimension - 1 - layer;
      for (int element = first; element < last; element++) {

        final int offset = element - first;

        // Save elements
        final int topLeft = matrix[first][first + offset];
        final int topRight = matrix[first + offset][last];
        final int bottomLeft = matrix[last - offset][first];
        final int bottomRight = matrix[last][last - offset];

        matrix[first][first + offset] = bottomLeft;
        matrix[first + offset][last] = topLeft;
        matrix[last - offset][first] = bottomRight;
        matrix[last][last - offset] = topRight;

      }

    }

  }

}
