import java.util.Stack;

public class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int poppedValue = stack.pop();
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }



public static void main(String[] args) throws Exception {

    MinStack minStack = new MinStack();

    minStack.push(512);
    System.out.println("Push 512 " + minStack.stack + "\n");

    minStack.push(-1024);
    System.out.println("Push -1024 " + minStack.stack + "\n");

    minStack.push(-1024);
    System.out.println("Push -1024 " + minStack.stack + "\n");

    minStack.push(512);
    System.out.println("Push 512 " + minStack.stack + "\n");

    minStack.pop();
    System.out.println("Popped " + minStack.stack + "\n");

    System.out.println("Minimum " + minStack.getMin() + "\n");

    minStack.pop();
    System.out.println("Popped " + minStack.stack + "\n");

    System.out.println("Minimum " + minStack.getMin() + "\n");

    minStack.pop();
    System.out.println("Popped " + minStack.stack + "\n");

    System.out.println("Minimum " + minStack.getMin() + "\n");
    }
}

//     Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

//     MinStack() initializes the stack object.
//     void push(int val) pushes the element val onto the stack.
//     void pop() removes the element on the top of the stack.
//     int top() gets the top element of the stack.
//     int getMin() retrieves the minimum element in the stack.

// You must implement a solution with O(1) time complexity for each function.

 

// Example 1:

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2