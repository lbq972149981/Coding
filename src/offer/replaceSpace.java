package offer;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 */
public class replaceSpace {
   public static void main(String[] args) {
      System.out.println(new replaceSpace().replaceSpace(new StringBuffer("We Are Happy")));
   }
   public String replaceSpace(StringBuffer str) {
      return str.toString().replaceAll(" ","%20");
   }
}
