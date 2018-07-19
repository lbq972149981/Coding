package offer;
import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class minNum {
   Stack<Integer> minStack = new Stack<>();
   Stack<Integer> stack = new Stack<>();
   public void push(int value) {
      stack.push(value);
      if(minStack.empty()){
         minStack.push(value);
      }else if(value<=minStack.peek()){
         minStack.push(value);
      }
   }
   public void pop() {
      if(stack.peek()==minStack.peek())
         minStack.pop();
      stack.pop();
   }

   public int top() {
      return stack.peek();
   }

   public int min() {
      return minStack.peek();
   }
}
