import utils.Utils;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given
 * two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
 * isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 * <p>
 * Created on the 11th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class OnePoint8 {

  public static void main(String[] args) {

    String s1 = "waterbottle", s2 = "erbottlewat";
    System.out.println(isRotation(s2, s1));

  }

  private static boolean isRotation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    return Utils.isSubstring(s1.concat(s1), s2) != -1;
  }

}
