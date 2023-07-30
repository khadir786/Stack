import java.util.Stack;

public class Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()){
            try {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            }
            else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            }
            
            else return false;
            } catch (Exception e) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }



public static void main(String[] args) throws Exception {
        Parentheses pa = new Parentheses();
        String chars = "]";

        boolean result = pa.isValid(chars);
        System.out.println((result));
    }
}



// CLEAN SOLUTION FROM LEETCODE SOLUTIONS
// public boolean isValid(String s) {
// 	Stack<Character> stack = new Stack<Character>();
// 	for (char c : s.toCharArray()) {
// 		if (c == '(')
// 			stack.push(')');
// 		else if (c == '{')
// 			stack.push('}');
// 		else if (c == '[')
// 			stack.push(']');
// 		else if (stack.isEmpty() || stack.pop() != c)
// 			return false;
// 	}
// 	return stack.isEmpty();
// }