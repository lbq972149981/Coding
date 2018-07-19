package offer;

import java.util.*;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * [2,4,3,6,3,2,5,5]
 * 4,6
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {
   public static void main(String[] args) {
      //[2,4,3,6,3,2,5,5]
      int arr[] = {2,4,3,6,3,2,5,5};
      int num1[] = new int[1];
      int num2[] = new int[1];
      new FindNumsAppearOnce().FindNumsAppearOnce2(arr,num1,num2);
   }
   public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
      Arrays.sort(array);
      int max = array[array.length-1];
      int min = array[0];
      int[] temp = new int[max+1];
      int result[] = new int[2];
      int k =0;
      for(int i=0;i<array.length;i++){
         temp[array[i]]++;
      }
      for(int i=0;i<temp.length;i++){
         if(temp[i]==1){
            result[k] = i;
            k++;
         }
      }
      num1[0] = result[0];
      num2[0] = result[1];
   }
   public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
      List<Integer> list = new ArrayList<>();
      for(int i=0;i<array.length;i++){
         if(!list.contains(array[i])){
            list.add(array[i]);
         }else {
            list.remove(Integer.valueOf(array[i]));
         }
      }
      num1[0] = list.get(0);
      num2[0] = list.get(1);
   }

   public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
      int re = 0;
      //2,4,3,6,3,2,5,5
      for(int i=0;i<array.length;i++){
         re ^= array[i];
      }
      System.out.println(re);
      System.out.println(4^6);
   }
}
