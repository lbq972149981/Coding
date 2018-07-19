package offer;

import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class FindKthToTail {
   public class ListNode {
      int val;
      ListNode next = null;

      ListNode(int val) {
         this.val = val;
      }
   }
   public int getSize(ListNode head){
      int size = 0;
      while(head!=null){
         size++;
         head = head.next;
      }
      return size;
   }
   public ListNode FindKthToTail(ListNode head,int k) {
      int size = getSize(head);
      int index = size-k;
      if(index<0)
         return null;
      int count = 0;
      while(head!=null&&count<index){
         head = head.next;
         count++;
      }
      return head;
   }
   //双指针遍历
   public ListNode FindKthToTail1(ListNode head,int k) {
      ListNode firstNode = head;
      ListNode lastNode = head;
      int count = 0;
      int kk = k;
      while(firstNode!=null){
         count++;
         firstNode = firstNode.next;
         if(k<1)
            lastNode = lastNode.next;
         k--;
      }
      if(count<kk)return null;
      return lastNode;
   }
   //链表节点翻转
   public ListNode FindKthToTail2(ListNode head,int k) {
      if(head==null)
         return null;
      int count = 0;
      int kk = k;
      Stack<ListNode> listNodes = new Stack<>();
      ListNode lastNode = null;
      while(head!=null){
         listNodes.push(head);
         head = head.next;
         count++;
      }
      if(count<kk)return null;
      while(k-->0){
         lastNode = listNodes.pop();
      }
      return lastNode;
   }
}
