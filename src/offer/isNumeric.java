package offer;

/**
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class isNumeric {
   public boolean isNumeric(char[] str) {
      boolean sign = false;
      boolean decimal = false;
      boolean hasE = false;
      boolean Epoint = false;
     for(int i=0;i<str.length;i++){
        //E/e不能为最后一个，且不能出现两次
        if(str[i]=='e'||str[i]=='E'){
           if(i==str.length-1)return false;
           if(hasE)return false;
           hasE = true;
        }
        //+/-出现两次，一次在e/E之前，一次在e/E之后
        //+/-出现一次，在第一个或者在e/E的前面
        else if(str[i]=='+'||str[i]=='-'){
           if(sign&&str[i-1]!='e'&& str[i-1]!='E')return false;
           if(!sign&&i>0&&str[i-1]!='e'&&str[i-1]!='E')return false;
           sign = true;
        }
        //.出现一次或者在e/E之前出现
        else if(str[i]=='.'){
           for(int j=0;j<i;j++){
              if(str[j]=='e'||str[j]=='E'){
                 Epoint = true;
              }
           }
           if(Epoint||decimal)return false;
           decimal = true;
        }
        //其他非法字符
        else if(str[i]<'0'||str[i]>'9'){
           return false;
        }
     }
     return true;
   }
}
