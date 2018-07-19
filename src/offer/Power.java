package offer;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
   public static void main(String[] args) {
      System.out.println(new Power().Power1(2,10));
   }
   //5^6
   public double Power(double base, int exponent) {
      if(base==0.0&&exponent<0)
         return 0.0;
      boolean flag = false;
      double res = 1;
      if(exponent<0){
         exponent = -exponent;
         flag = true;
      }
      for(int i=0;i<exponent;i++){
         res *= base;
      }
      if(flag){
         res = 1/res;
      }
      return res;
   }

   public double Power1(double base, int exponent) {
      boolean flag = false;
      if(base-0.0>-0.000001&&base-0.0<0.000001&&exponent<0){
         flag = true;
         return 0.0;
      }
      int absexponent = exponent;
      if(exponent<0){
         absexponent = -exponent;
      }
      double res = getPower(base,absexponent);
      if(exponent<0){
         res = 1/res;
      }
      return res;
   }
   private double getPower(double base, int absexponent) {
     if(absexponent==0)return 1.0;
     if(absexponent==1)return base;
     double result = getPower(base,absexponent>>1);
     result*=result;
     if((absexponent&1)==1)result*=base;
     return result;
   }
}
