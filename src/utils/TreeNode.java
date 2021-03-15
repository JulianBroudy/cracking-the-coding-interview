package utils;

/**
 * Tree node class.
 * <p>
 * Created on the 15th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class TreeNode<T> {

  TreeNode<T> left, right;
  T data;

  public TreeNode(T data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  /**
   * Gets the left.
   *
   * @return left's value.
   */
  public TreeNode<T> getLeft() {
    return left;
  }

  /**
   * Sets the left.
   *
   * @param left is the left's new value.
   */
  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }

  /**
   * Sets the left.
   *
   * @param leftData is the left's node data.
   */
  public void setLeft(T leftData) {
    this.left = new TreeNode<>(leftData);
  }

  /**
   * Gets the right.
   *
   * @return right's value.
   */
  public TreeNode<T> getRight() {
    return right;
  }

  /**
   * Sets the right.
   *
   * @param right is the right's new value.
   */
  public void setRight(TreeNode<T> right) {
    this.right = right;
  }

  /**
   * Sets the right.
   *
   * @param rightData is the right's node data.
   */
  public void setRight(T rightData) {
    this.right = new TreeNode<>(rightData);
  }


}
