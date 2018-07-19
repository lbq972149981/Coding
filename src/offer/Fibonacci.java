package offer;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class Fibonacci {
   public static void main(String[] args) {
      System.out.println(new Fibonacci().Fibonacci(24));
      System.out.println(new Fibonacci().Fibonacci1(24));
      System.out.println(new Fibonacci().Fibonacci2(24));
      System.out.println(new Fibonacci().Fibonacci3(24));
   }
   /**迭代*/
   public int Fibonacci(int n) {
     int f = 0;
     int g = 1;
     while(n-->0){
        g = g + f;
        f = g - f;
     }
     return f;
   }
   //递归
   public int Fibonacci1(int n) {
      if(n==0)return 0;
      if(n==1)return 1;
      return Fibonacci1(n-1)+Fibonacci1(n-2);
   }
   //尾递归
   public int Fibonacci3(int n){
      return Fibonacci3(n,0,1);
   }
   public int Fibonacci3(int n,int ac1,int ac2) {
      if(n==0)return 0;
      if(n==1)return ac2;
      return Fibonacci3(n-1,ac2,ac1+ac2);
   }
   //数组
   public int Fibonacci2(int n) {
     int A[] = new int[40];
     A[0] = 0;
     A[1] = 1;
     for(int i=2;i<A.length;i++){
        A[i] = A[i-1] + A[i-2];
     }
     return A[n];
   }
}
