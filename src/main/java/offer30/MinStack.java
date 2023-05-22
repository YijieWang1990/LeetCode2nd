package offer30;

import java.util.Stack;

class MinStack {

  private final Stack<Integer> stack1;
  private final Stack<Integer> stack2;
  public MinStack() {
    this.stack1 = new Stack<>();
    this.stack2 = new Stack<>();
  }

  public void push(int x) {
    stack1.push(x);
    if (stack2.isEmpty()) {
      stack2.push(x);
    } else {
      stack2.push(Math.min(stack2.peek(), x));
    }
  }

  public void pop() {
    if (!stack1.isEmpty()) {
      stack1.pop();
      stack2.pop();
    }
  }

  public int top() {
    return stack1.isEmpty()? -1:stack1.peek();
  }

  public int min() {
    return stack2.isEmpty() ? -1 : stack2.peek();
  }
}
