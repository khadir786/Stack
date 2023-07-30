import java.util.Stack;

public class RPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>(); 
        int result = 0;  
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

}