import java.util.Stack;

public class RPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>(); 
        int result = 2; // 4, 13, 5, /, +    
        for (String s : tokens) {
            if (isNumber(s)) {
                operands.push(Integer.parseInt(s));
                System.out.println("\n" + operands);
            }
            else if (s == "+" && !operands.isEmpty()) {
                // result = operands.pop() + operands.pop();
                int op2 = operands.pop(); 
                int op1 = operands.pop(); 
                result = op1 + op2;
                System.out.println(op1 + " + " + op2 + " = " + op1 + op2);
                operands.push(result);
                System.out.println("\n" + operands);
            }
            else if (s == "-" && !operands.isEmpty()) {
                // result = operands.pop() - operands.pop();
                int op2 = operands.pop(); 
                int op1 = operands.pop(); 
                result = op1 - op2;
                System.out.println(op1 + " - " + op2 + " = " + op1 + op2);
                operands.push(result);
                System.out.println("\n" + operands);
            }
            else if (s == "*" && !operands.isEmpty()) {
                // result = operands.pop() * operands.pop();
                int op2 = operands.pop(); 
                int op1 = operands.pop(); 
                result = op1 * op2;
                System.out.println(op1 + " * " + op2 + " = " + op1 * op2);
                operands.push(result);
                System.out.println("\n" + operands);
            }
            else if (s == "/" && !operands.isEmpty()) {
                // result = operands.pop() / operands.pop();
                int op2 = operands.pop(); 
                int op1 = operands.pop(); 
                result = op1 / op2;
                System.out.println(op1 + " / " + op2 + " = " + op1 / op2);
                operands.push(result);
                System.out.println("\n" + operands);
            }
        }
 

        return result;
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        RPN rpn = new RPN();
        String[] input = {"4","13","5","/","+"};

        int result = rpn.evalRPN(input);
        System.out.println((result));
    }
}


// create a stack, add 2 numbers to the stack 
// if the input isn't an integer then save the input as an operator variable
// stack.pop() + operator  