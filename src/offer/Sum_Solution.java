package offer;

/**
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution {

   public static void main(String[] args) {
      System.out.println(new Sum_Solution().Sum_Solution1(100));
   }
   public int Sum_Solution(int n) {
      int ans = n;
      boolean t = (ans!=0 && ((ans+=Sum_Solution(n-1))!=0));
      return ans;
   }
   public int Sum_Solution1(int n) {
     try {
       int i = 1%n;
       return n+Sum_Solution(n-1);
     }catch (ArithmeticException e){
       return 0;
     }
   }
}
