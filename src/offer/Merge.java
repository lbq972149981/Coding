package offer;

/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
   public class ListNode {
      int val;
      ListNode next = null;

      ListNode(int val) {
         this.val = val;
      }
   }
   public ListNode Merge(ListNode list1,ListNode list2) {
      ListNode head = null;
      if(list1!=null&&list2!=null) {
         if (list1.val > list2.val) {
            head = new ListNode(list2.val);
            list2 = list2.next;
         } else {
            head = new ListNode(list1.val);
            list1 = list1.next;
         }
      }else {
         if(list1==null)
            return list2;
         else
            return list1;
      }
      ListNode res = head;
      while(list1!=null&&list2!=null){
         if(list1.val>list2.val){
            head.next = new ListNode(list2.val);
            list2 = list2.next;
         }else {
            head.next = new ListNode(list1.val);
            list1 = list1.next;
         }
         head = head.next;
      }
      while(list1!=null){
         head.next = new ListNode(list1.val);
         head = head.next;
         list1 = list1.next;
      }
      while(list2!=null){
         head.next = new ListNode(list2.val);
         head = head.next;
         list2 = list2.next;
      }
      head.next = null;
      return res;
   }
   public ListNode Merge1(ListNode list1,ListNode list2) {
      if(list1==null)return list2;
      if(list2==null)return list1;
      ListNode res = null;
      if(list1.val<=list2.val){
         res = list1;
         res.next = Merge1(list1.next,list2);
         return list1;
      }else {
         res = list2;
         res.next = Merge1(list1,list2.next);
         return res;
      }
   }
}
