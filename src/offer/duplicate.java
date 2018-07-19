package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class duplicate {
   // Parameters:
   //    numbers:     an array of integers
   //    length:      the length of array numbers
   //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
   //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
   //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
   // Return value:       true if the input is valid, and there are some duplications in the array number
   //                     otherwise false
   public static void main(String[] args) {
      int[] arr = {2,3,1,0,2,5,3};
      int[] temp = new int[1];
      System.out.println(new duplicate().duplicate1(arr,arr.length,temp));
   }
   public boolean duplicate(int numbers[],int length,int [] duplication) {
      if(numbers==null) {
         duplication[0] = -1;
         return false;
      }
      Set<Integer> set = new HashSet<>();
      set.add(numbers[0]);
      for(int i=1;i<length;i++){
         int len1 = set.size();
         set.add(numbers[i]);
         int len2 = set.size();
         if(len1==len2){
            duplication[0] = numbers[i];
            return true;
         }
      }
      return false;
   }
   public boolean duplicate1(int numbers[],int length,int [] duplication) {
      if(numbers==null) {
         duplication[0] = -1;
         return false;
      }
      for(int i=0;i<length;i++){
         int index = numbers[i];
         if(index>=length){
            index -= length;
         }
         if(numbers[index]>length){
            duplication[0] = index;
            return true;
         }
         numbers[index] = numbers[index] + length;
      }
      duplication[0] = -1;
      return false;
   }
}
