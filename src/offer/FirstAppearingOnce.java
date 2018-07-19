package offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 题目描述
 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 输出描述:
 如果当前字符流没有存在出现一次的字符，返回#字符
 */
public class FirstAppearingOnce {
   int[] hashtable = new int[256];
   StringBuffer sb = new StringBuffer();
   //Insert one char from stringstream
   public void Insert(char ch)
   {
      sb.append(ch);
      if(hashtable[ch]==0)
         hashtable[ch]=1;
      else
         hashtable[ch] += 1;
   }
   //return the first appearence once char in current stringstream
   public char FirstAppearingOnce()
   {
      char str[] = sb.toString().toCharArray();
      for(char c:str){
         if(hashtable[c]==1)return c;
      }
      return '#';
   }

   HashMap<Character,Integer> map = new HashMap<>();
   ArrayList<Character> chars = new ArrayList<>();
   public void Insert1(char ch)
   {
      chars.add(ch);
      if(map.containsKey(ch)){
         map.put(ch,map.get(ch)+1);
      }else {
         map.put(ch,1);
      }
   }
   //return the first appearence once char in current stringstream
   public char FirstAppearingOnce1()
   {
      for(char c:chars){
         if(map.get(c)==1)return c;
      }
      return '#';
   }
}
