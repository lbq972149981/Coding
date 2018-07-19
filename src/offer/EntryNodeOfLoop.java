package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoop {
   public class ListNode {
      int val;
      ListNode next = null;

      ListNode(int val) {
         this.val = val;
      }
   }
   public ListNode EntryNodeOfLoop(ListNode pHead)
   {
      if(pHead==null||pHead.next==null)return null;
      List<ListNode> listNodes = new ArrayList<>();
      while(!listNodes.contains(pHead)){
         listNodes.add(pHead);
         pHead = pHead.next;
      }
      return pHead;
   }
   public ListNode EntryNodeOfLoop1(ListNode pHead)
   {
      if(pHead==null||pHead.next==null)return null;
      ListNode pre = pHead;
      ListNode front = pHead.next;
      while(front!=null){
         pre.next = null;
         pre = front;
         front = front.next;
      }
      return pre;
   }
}
