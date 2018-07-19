package offer;

/**
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
   public static void main(String[] args) {
      System.out.println(new NumberOf1().NumberOf1(6));
      System.out.println(new NumberOf1().NumberOf1_1(6));
   }
   public int NumberOf1(int n) {
      int count = 0;
      int flag = 1;
      while(flag!=0){
         if((n&flag)!=0){
            count++;
         }
         flag = flag << 1;
      }
      return count;
   }
   public int NumberOf1_1(int n) {
      int count = 0;
      while(n!=0){
         ++count;
         n = (n-1)&n;
      }
      return count;
   }
}
