package offer;

/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
   //尾递归
   public int RectCover(int target) {
      if (target<1)return 0;
      return RectCover(target,1,2);
   }
   private int RectCover(int target, int ac1, int ac2) {
      if(target==1)return 1;
      if(target==2)return ac2;
      return RectCover(target-1,ac2,ac1+ac2);
   }
   //递归
   public int RectCover1(int target){
      if(target<1)return 0;
      if(target*2==2)return 1;
      if(target*2==4)return 2;
      return RectCover1(target-1)+RectCover1(target-2);
   }
}
