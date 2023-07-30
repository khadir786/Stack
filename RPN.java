import java.util.Stack;

public class RPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>(); 
        int result;  
        for (String s : tokens) {
            if (isNumber(s)) {
                operands.push(Integer.parseInt(s));
            }
            else if (s.equals("+") && !operands.isEmpty()) {
                int op2 = operands.pop(); 
                int op1 = operands.pop(); 
                result = op1 + op2;
                operands.push(result);
            }
            else if (s.equals("-") && !operands.isEmpty()) {
                int op2 = operands.pop(); 
                int op1 = operands.pop(); 
                result = op1 - op2;
                operands.push(result);
            }
            else if (s.equals("*") && !operands.isEmpty()) {
                int op2 = operands.pop(); 
                int op1 = operands.pop(); 
                result = op1 * op2;
                operands.push(result);
            }
            else if (s.equals("/") && !operands.isEmpty()) {
                int op2 = operands.pop(); 
                int op1 = operands.pop(); 
                result = op1 / op2;
                operands.push(result);
            }
        }
        return operands.pop();
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    // To improve, get rid of result variable. Add result of operations to the stack. Initialise op1 and op2 at the beginning 
}