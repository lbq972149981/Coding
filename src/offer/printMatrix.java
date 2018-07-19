package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class printMatrix {
   public static void main(String[] args) {
      int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
      new printMatrix().printMatrix(arr);
      new printMatrix().printMatrix1(arr);
   }
   public ArrayList<Integer> printMatrix(int [][] matrix) {
      ArrayList<Integer> list = new ArrayList<>();
      int row = matrix.length;
      int col = matrix[0].length;
      int circle = ((row>col?col:row)+1)/2;
      for(int i=0;i<circle;i++){
         for(int j=i;j<col-i;j++)list.add(matrix[i][j]);
         for(int j=i+1;j<row-i;j++)list.add(matrix[j][col-i-1]);
         for(int j=col-i-2;j>=i&&row-i-1!=i;j--)list.add(matrix[row-i-1][j]);
         for(int j=row-i-2;j>i&&col-i-1!=i;j--)list.add(matrix[j][i]);
      }
      return list;
   }
   //魔方方法
   public ArrayList<Integer> printMatrix1(int [][] matrix) {
      ArrayList<Integer> list = new ArrayList<>();
      int row = matrix.length;
      while(row!=0){
         for(int i=0;i<matrix[0].length;i++){
            list.add(matrix[0][i]);
         }
         if(row==1)break;
         matrix = turn(matrix);
         row = matrix.length;
      }
      System.out.println(list);
      return list;
   }
   private int[][] turn(int[][] matrix) {
      int col = matrix[0].length;
      int row = matrix.length;
      int[][] newmatrix = new int[col][row-1];
      for(int j=col-1;j>=0;j--){
         for(int i=1;i<row;i++){
            newmatrix[col-1-j][i-1] = matrix[i][j];
         }
      }
      return newmatrix;
   }
}
