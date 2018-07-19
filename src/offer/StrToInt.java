package offer;

/**
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class StrToInt {
   public static void main(String[] args) {
      System.out.println(new StrToInt().StrToInt1("la45"));
   }
   public int StrToInt(String str) {
      if(str.trim().equals(""))
         return 0;
      boolean flag = true;
      for(char c:str.toCharArray()){
         if(Character.isDigit(c)||c=='+'||c=='-'){
            flag = true;
         }else {
            flag = false;
            break;
         }
      }
      if(flag){
         int len = 0;
         if(str.charAt(0)=='+'||str.charAt(0)=='-') {
            len = str.length()-1;
         }else {
            len = str.length();
         }
         long sum = 0;
         boolean f = false;
         for(char c:str.toCharArray()){
            if(c=='-')
               f = true;
            if(Character.isDigit(c)) {
               int temp = (int) c-48;
               sum +=temp* (long) Math.pow(10,len-1);
               len--;
            }
         }
         return f?0-(int)sum:(int)sum;
      }else {
         return 0;
      }
   }
   public int StrToInt1(String str) {
      if(str.trim().equals(""))
         return 0;
      boolean flag = true;
      for(char c:str.toCharArray()){
         if(Character.isDigit(c)||c=='+'||c=='-'){
            flag = true;
         }else {
            flag = false;
            break;
         }
      }
      if(flag) {
         int len = str.length();
         int fuhao = 1;
         long res = 0;
         if (str.charAt(0) == '-') fuhao = -1;
         for (int i = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0; i < len; i++) {
            res = (res << 1) + (res << 3) + (str.charAt(i) & 0xf);
         }
         return (int) res * fuhao;
      }else {
         return 0;
      }
   }
}
