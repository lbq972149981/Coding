package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述
 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class LastRemaining_Solution {
   public static void main(String[] args) {
      System.out.println(new LastRemaining_Solution().LastRemaining_Solution2(10,3));
   }
   public int LastRemaining_Solution(int n, int m) {
      if(n==0&&m==0)return -1;
      List<Integer> child = new LinkedList<>();
      for(int i=0;i<n;i++){
         child.add(i);
      }
      int k = 0;
      for(int i=0;i<m&&n>1;i++){
         if(i==m-1){
            child.remove(k);
            i=0;
            i--;
            n--;
            k--;
         }
         k++;
         if(k==n)k = k%n;
         if(child.size()==1){
            break;
         }
      }
      return child.get(0);
   }
   public int LastRemaining_Solution1(int n, int m) {
      if(n==0&&m==0)return -1;
      List<Integer> child = new LinkedList<>();
      for(int i=0;i<n;i++){
         child.add(i);
      }
      int index = -1;
      while(child.size()>1){
         index = (index+m)%child.size();
         child.remove(index);
         index--;
      }
      return child.get(0);
   }
   public int LastRemaining_Solution2(int n, int m) {
     Node head = new Node(0);
     Node pre = head;
     Node temp = null;
     for(int i=1;i<n;i++){
        temp = new Node(i);
        pre.next = temp;
        pre = pre.next;
     }
     pre.next = head;
     Node temp2 = null;
     while(n!=1){
        temp2 = head;
        for(int i=1;i<m-1;i++){
           temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        head = temp2.next;
        n--;
     }
     return head.value;
   }
   //链表
   public class Node{
      int value;
      Node next;
      public Node(int value) {
         this.value = value;
      }
   }


   public int LastRemaining_Solution3(int n, int m) {
      if(n<1||m<1)return -1;
      if(n==1)return 0;
      return (LastRemaining_Solution3(n-1,m)+m)%n;
   }
}
