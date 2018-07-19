package offer;

/**
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
   public static void main(String[] args) {
      System.out.println(new Add().Add1(1,2));
   }
   public int Add(int num1,int num2) {
      int res = 0;
      if(num1>0&&num2>0){
         while(num1-->0){
            res++;
         }
         while (num2-->0){
            res++;
         }
      }else if(num1<0&&num2<0){
         while(num1++<0){
            res--;
         }
         while (num2++<0){
            res--;
         }
      } else if(num1<0&&num2>0){
         while(num1++<0){
            res--;
         }
         while (num2-->0){
            res++;
         }
      } else{
         while(num1-->0){
            res++;
         }
         while (num2++<0){
            res--;
         }
      }
      return res;
   }
   /**
    两个数异或：相当于每一位相加，而不考虑进位；
    两个数相与，并左移一位：相当于求得进位；
    将上述两步的结果相加
    */
   public int Add1(int num1,int num2) {
      while(num2!=0){
         int temp = num1^num2;//二进制两数相加,不算进位值
         num2 = (num1&num2)<<1;//计算进位值
         num1 = temp;
      }
      return num1;
   }
}
