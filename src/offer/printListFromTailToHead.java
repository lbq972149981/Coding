package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class printListFromTailToHead {
    public class ListNode {
     int val;
     ListNode next = null;

          ListNode(int val) {
         this.val = val;
     }
    }
   public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
      Stack<Integer> stack = new Stack<>();
      while(listNode!=null){
         stack.push(listNode.val);
         listNode = listNode.next;
      }
      ArrayList<Integer> list = new ArrayList<>();
      while (!stack.isEmpty()){
         list.add(stack.pop());
      }
      return list;
   }
}
