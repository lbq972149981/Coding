package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {
   public int GetUglyNumber_Solution(int index) {
      if(index<=0)return 0;
      List<Integer> list = new ArrayList<>();
      list.add(1);
      int i2=0,i3=0,i5=0;
      while(list.size()<index){
         int num2 = list.get(i2)*2;
         int num3 = list.get(i3)*3;
         int num5 = list.get(i5)*5;
         int min = Math.min(num2,Math.min(num3,num5));
         list.add(min);
         if(min==num2)i2++;
         if(min==num3)i3++;
         if(min==num5)i5++;
      }
      return list.get(list.size()-1);
   }
}
