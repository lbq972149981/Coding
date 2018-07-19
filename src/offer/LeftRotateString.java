package offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
   public static void main(String[] args) {
      System.out.println(new LeftRotateString().LeftRotateString3("",12));
   }
   public String LeftRotateString(String str,int n) {
      ArrayDeque<String> queue = new ArrayDeque<>();
      if(str==null||"".equals(str))
         return "";
      for(char c:str.toCharArray()){
         queue.add(c+"");
      }
      for(int i=0;i<n;i++){
         queue.add(queue.remove());
      }
      StringBuffer sb = new StringBuffer();
      for(String s:queue){
         sb.append(s);
      }
      return sb.toString();
   }
   public String LeftRotateString1(String str,int n) {
      int len = str.length();
      if(len==0) return "";
      str +=str;
      int index = n;
      index = index%len;
      return str.substring(index,len+index);
   }
   public String LeftRotateString2(String str,int n) {
      if(str.length()==0)
         return "";
      String  x = str.substring(0,n%str.length());
      String  y = str.substring(n%str.length(),str.length());
      String xTyT = new StringBuffer(x).reverse().toString()+new StringBuffer(y).reverse().toString();
      String xTyTT = new StringBuffer(xTyT).reverse().toString();
      return xTyTT;
   }
   public String LeftRotateString3(String str,int n) {
      if(str.length()==0)
         return "";
      StringBuffer s1 = new StringBuffer(str.substring(0,n%str.length()));
      StringBuffer s2 = new StringBuffer(str.substring(n%str.length(),str.length()));
      StringBuffer sb = new StringBuffer(s2);
      sb.append(s1);
      return sb.toString();
   }
}
