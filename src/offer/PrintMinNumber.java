package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
   public String PrintMinNumber(int [] numbers) {
      List<String> stringList = new ArrayList<>();
      for(int i=0;i<numbers.length;i++){
         stringList.add(numbers[i]+"");
      }
      Collections.sort(stringList, new Comparator<String>() {
         @Override
         public int compare(String o1, String o2) {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
         }
      });
      StringBuffer sb = new StringBuffer();
      stringList.forEach(v->sb.append(v));
      return sb.toString();
   }
}