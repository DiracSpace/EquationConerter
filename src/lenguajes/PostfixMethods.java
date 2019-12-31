package lenguajes;

import java.util.Stack;

public class PostfixMethods {
    
    // check importance in operands
    private static int Importance(char d) {
        
        /*
        *
        * Order of importances or precedence
        * 1 - exponents
        * 2 - division and multiplication
        * 3 - addition and substraction
        *
        * */
        
        switch(d) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    
    // Infix to Postfix
    public String Postfix(String equation) {
        
        String result = "";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            char piece = equation.charAt(i);

            if (Importance(piece) > 0) {
                //revisar si es operador
                while (s.isEmpty() == false && Importance(s.peek()) >= Importance(piece)) {
                    result += s.pop();
                }
                s.push(piece);
            } else if (piece == ')') {
                // el valor no es operador
                // entonces debe ser parentesis o valor
                char flag = s.pop();
                while (flag != '(') {
                    result += flag;
                    flag = s.pop();
                }
            } else if (piece == '(') {
                s.push(piece);
            } else {
                // el dato no es operador ni parentesis
                result += piece;
            }
        }
        for (int i = 0; i <= s.size(); i++) {
            result += s.pop();
        }
        return result;
    }
    
    private static boolean Check (char value) {
        switch(value) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }
    
    // Postfix to Infix
    public String returnPostfixToInfix(String equation) {
        
        Stack<String> s = new Stack<>();
        
        for (int i = 0; i < equation.length(); i++) {
            char value = equation.charAt(i);
            if (Check(value)) {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                String concatenation = "("+value+op1+op2+")";
                
                s.push(concatenation);
            } else {
                s.push(value + "");
            }
        }
        return s.peek();
    }
}