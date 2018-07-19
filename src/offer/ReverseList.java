package offer;

import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseList {
   public class ListNode {
      int val;
      ListNode next = null;
      ListNode(int val) {
         this.val = val;
      }
   }
   public ListNode ReverseList(ListNode head) {
      if(head==null)return null;
      //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
      //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
      //所以需要用到pre和next两个节点
      ListNode pre = null;
      ListNode next = null;
      while(head!=null){
         next = head.next;
         head.next = pre;
         pre = head;
         head = next;
      }
      return pre;
   }
   public ListNode ReverseList1(ListNode head) {
      if(head==null||head.next==null)return head;
      Stack<ListNode> listNodes = new Stack<>();
      ListNode temp = head;
      ListNode newHead = null;
      while(temp.next!=null){
         listNodes.push(temp);
         temp = temp.next;
      }
      newHead = temp;
      while(!listNodes.isEmpty()){
         temp.next = listNodes.pop();
         temp = temp.next;
      }
      temp.next = null;
      return newHead;
   }
}
