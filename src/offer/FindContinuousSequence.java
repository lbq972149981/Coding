package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
   public static void main(String[] args) {
      System.out.println(new FindContinuousSequence().FindContinuousSequence1(100));
   }
   public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<>();
      int begin = 1;
      int end = 2;
      int cur = begin + end;
      int mid = (1+sum)/2;
      if(sum<3){
         return res;
      }
      while (begin<mid && end<sum){
         while(cur>sum){
            cur -= begin;
            begin++;
         }
         if(cur==sum){
            ArrayList<Integer> Sequence = new ArrayList<>();
            for(int i=begin;i<=end;i++){
               Sequence.add(i);
            }
            res.add(Sequence);
         }
         end++;
         cur += end;
      }
      return res;
   }
   /**
    * 根据等差数列的求和公式：S = (1 + n) * n / 2，得到.n<Math.sqrt(2S)
    * **/
   public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
      int right = (int) Math.sqrt((double) sum*2);
      ArrayList<ArrayList<Integer>> res = new ArrayList<>();
      for(int n=right;n>=2;n--){

         if(n%2==1&&sum%n==0||(sum%n)*2==n){
            ArrayList<Integer> arrayList = new ArrayList();
            for(int j=0,k=(sum/n)-(n-1)/2;j<n;j++,k++){
               arrayList.add(k);
            }
            res.add(arrayList);
         }
      }
      return res;
   }
}
