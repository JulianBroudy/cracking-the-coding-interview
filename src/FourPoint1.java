import utils.BTreePrinter;
import utils.TreeNode;

/**
 * Implement a function to check if a tree is balanced. For the purposes of this question,
 * a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
 * from the root by more than one.
 * <p>
 * Created on the 15th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class FourPoint1 {

  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(1);
    TreeNode<Integer> level2Left = new TreeNode<>(2);
    TreeNode<Integer> level2Right = new TreeNode<>(3);
    root.setLeft(level2Left);
    root.setRight(level2Right);
    TreeNode<Integer> level3Left = new TreeNode<>(4);
    level2Right.setLeft(level3Left);
    level3Left.setLeft(5);
    BTreePrinter.printNode(root);
    System.out.println(isBalanced(root));
  }

  private static boolean isBalanced(TreeNode<Integer> root) {
    return getMaxDepth(root) - getMinDepth(root) < 2;
  }

  private static int getMaxDepth(TreeNode<Integer> node) {
    if (node == null) {
      return 0;
    }
    return Math.max(getMaxDepth(node.getLeft()), getMaxDepth(node.getRight())) + 1;
  }

  private static int getMinDepth(TreeNode<Integer> node) {
    if (node == null) {
      return 0;
    }
    return Math.min(getMaxDepth(node.getLeft()), getMaxDepth(node.getRight())) + 1;
  }


}
