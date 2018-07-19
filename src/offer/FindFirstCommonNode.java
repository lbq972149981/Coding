package offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
   public class ListNode {
      int val;
      ListNode next = null;

      ListNode(int val) {
         this.val = val;
      }
   }
   //套圈
   public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
      ListNode p1 = pHead1;
      ListNode p2 = pHead2;
      while(p1!=p2){
         p1 = (p1==null?pHead2:p1.next);
         p2 = (p2==null?pHead1:p2.next);
      }
      return p1;
   }
   public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
      int len1 = findLen(pHead1);
      int len2 = findLen(pHead2);
      if(len1>len2){
         pHead1 = walkStep(pHead1,len1-len2);
      }else {
         pHead2 = walkStep(pHead2,len2-len1);
      }
      while(pHead1!=pHead2){
         pHead1 = pHead1.next;
         pHead2 = pHead2.next;
      }
      return pHead1;
   }

   private ListNode walkStep(ListNode pHead, int step) {
      while(step>0){
         step--;
         pHead = pHead.next;
      }
      return pHead;
   }

   private int findLen(ListNode pHead) {
      if(pHead==null)return 0;
      int count = 0;
      while(pHead!=null){
         count++;
         pHead = pHead.next;
      }
      return count;
   }
}
