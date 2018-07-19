package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {
   public static void main(String[] args) {
      int[] arr = {1,2,3,4,5};
      new FindNumbersWithSum().FindNumbersWithSum1(arr,5);
   }
   public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
      ArrayList<Integer> list = new ArrayList<>();
      int min = sum*sum;
      Arrays.sort(array);
      for(int i=0;i<array.length;i++){
         if(array[i]>=sum){
            break;
         }
         for(int j=0;j<array.length;j++){
            if(array[j]>=sum){
               break;
            }
            if(array[i]+array[j]==sum&&array[i]*array[j]<min){
               min = array[i]*array[j];
               list.add(0,array[i]);
               list.add(1,array[j]);
            }
         }
      }
      return list;
   }
   public ArrayList<Integer> FindNumbersWithSum1(int [] array, int sum) {
      ArrayList<Integer> list = new ArrayList<>();
      int high = array.length-1;
      int low = 0;
      while(low < high){
         if(array[low]+array[high]==sum){
            list.add(array[low]);
            list.add(array[high]);
            break;
         }
         while(array[low]+array[high]>sum)high--;
         while(array[low]+array[high]<sum)low++;
      }
      return list;
   }
}
