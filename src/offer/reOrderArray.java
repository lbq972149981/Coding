package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class reOrderArray {
   public static void main(String[] args) {
      int[] arr = {4,1,2,4,9,7,6,1,8,7};
//      new reOrderArray().reOrderArray(arr);
      new reOrderArray().reOrderArray1(arr);
   }
   public void reOrderArray(int [] array) {
      List<Integer> odd = new ArrayList<>();
      List<Integer> even = new ArrayList<>();
      for(int i=0;i<array.length;i++){
         if(array[i]%2==0)
            even.add(array[i]);
         else
            odd.add(array[i]);
      }
      for(int i=0;i<odd.size();i++){
         array[i] = odd.get(i);
      }
      for(int i=odd.size();i<odd.size()+even.size();i++){
         array[i] = even.get(i-odd.size());
      }
      System.out.println(Arrays.toString(array));
   }
   //4,1,2,4,9,7,6,1,8,7
   //1 9 7 1 7 4 2 4 6 8
   public void reOrderArray1(int [] array) {
      int index = 0;
      for(int i=0;i<array.length;i++){
         if(array[i] % 2 != 0&&i==0) {
            index++;
            continue;
         }
         boolean flag = false;
         int temp = 0;
         if (array[i] % 2 != 0){
            temp = array[i];
            flag = true;
            for(int j=i;j>index;j--) {
               array[j] = array[j-1];
            }
         }
         if(flag)
            array[index++] = temp;
      }
   }
}
