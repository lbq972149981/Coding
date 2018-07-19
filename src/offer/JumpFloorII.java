package offer;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
/*
f(1) = 1
f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
f(3) = f(3-1) + f(3-2) + f(3-3) 
...
f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n) 
f(n) = 2*f(n-1)
 */
public class JumpFloorII {
   public static void main(String[] args) {
      System.out.println(new JumpFloorII().JumpFloorII(8));
      System.out.println(new JumpFloorII().JumpFloorII1(8));
   }
   public int JumpFloorII(int target) {
      if(target==1)return 1;
      return 2*JumpFloorII(target-1);
   }
   public int JumpFloorII1(int target) {
      return 1<<--target;
   }
}
