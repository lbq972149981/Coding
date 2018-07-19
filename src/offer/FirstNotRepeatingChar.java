package offer;

import java.util.*;

/**
 * 题目描述
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class FirstNotRepeatingChar {
   public static void main(String[] args) {
      System.out.println(new FirstNotRepeatingChar().FirstNotRepeatingChar("google"));
   }
   public int FirstNotRepeatingChar(String str) {
      if(str==null||"".equals(str))return -1;
      List<String> keys = new ArrayList<>();
      List<Integer> index = new ArrayList<>();
      Map<Character,Integer> map = new HashMap<>();
      for(char c:str.toCharArray()){
         if(map.get(c)==null){
            map.put(c,0);
         }
         map.put(c,map.get(c)+1);
      }
      for(Character k:map.keySet()){
         if(map.get(k)==1){
            keys.add(k+"");
         }
      }
      int j =0;
      for(String s:keys){
         index.add(str.indexOf(s));
      }
      Collections.sort(index);
      return index.get(0);
   }
   public int FirstNotRepeatingChar1(String str) {
      Map<Character,Integer> map = new HashMap<>();
      for(char c:str.toCharArray()){
         if(map.get(c)==null){
            map.put(c,0);
         }
         map.put(c,map.get(c)+1);
      }
      for(int i=0;i<str.length();i++){
         if(map.get(str.charAt(i))==1)
            return i;
      }
      return -1;
   }
}
