package offer;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor {
   public static void main(String[] args) {
      System.out.println(new JumpFloor().JumpFloor(18));
      System.out.println(new JumpFloor().JumpFloor1(18));
   }
   /*
      a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
      b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
      c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2) 
      d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
      e.可以发现最终得出的是一个斐波那契数列：
    */
   //递归
   public int JumpFloor(int target) {
      if(target==1)return 1;
      if(target==2)return 2;
      return JumpFloor(target-1)+JumpFloor(target-2);
   }
   //尾递归
   public int JumpFloor1(int target) {
      return JumpFloor1(target,1,2);
   }

   private int JumpFloor1(int target, int ac1, int ac2) {
      if(target==1)return 1;
      if (target==2)return ac2;
      return JumpFloor1(target-1,ac2,ac1+ac2);
   }
}
