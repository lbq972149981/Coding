package offer;

import java.util.Stack;

/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class StackToQueue {
   //["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
   Stack<Integer> stack1 = new Stack<Integer>();
   Stack<Integer> stack2 = new Stack<Integer>();
   public void push(int node) {
      stack1.push(node);
   }
   public int pop() {
      if(stack2.isEmpty()) {
         while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
         }
      }
      return stack2.pop();
   }
}
