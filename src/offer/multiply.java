package offer;

import java.util.Arrays;

/**
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class multiply {
   public static void main(String[] args) {
      int[] A = {1,2,3,4,5};
      System.out.println(Arrays.toString(new multiply().multiply1(A)));
   }
   public int[] multiply(int[] A) {
      int B[] = new int[A.length];
      int res = 1;
      for(int i=0;i<A.length;res*=A[i++]){
        B[i] = res;
      }
      res = 1;
      for(int i=A.length-1;i>=0;res*=A[i--]){
         B[i]*=res;
      }
      return B;
   }
   public int[] multiply1(int[] A) {
      int B[] = new int[A.length];
      int[] forword = new int[A.length];
      int[] backword = new int[A.length];
      forword[0] = 1;
      backword[0] = 1;
      for(int i=1;i<A.length;i++){
         forword[i] = A[i-1]*forword[i-1];
         backword[i] = A[A.length-i]*backword[i-1];
      }
      for(int i=0;i<A.length;i++){
         B[i] = forword[i]*backword[A.length-i-1];
      }
      return B;
   }
}
