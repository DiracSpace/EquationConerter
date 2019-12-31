package lenguajes;

import java.util.Stack;

public class PrefixMethods {
    
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
    
    public StringBuilder Prefix(String equation) {
        
        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(equation);
        input.reverse();
        Stack<Character> s = new Stack<>();
        
        char[] equationchar = new String(input).toCharArray();
        
        for (int i = 0; i < equationchar.length; i++) {
            if (equationchar[i] == '(') {
                equationchar[i] = ')';
                i++;
            } else if (equationchar[i] == ')') {
                equationchar[i] = '(';
                i++;
            }
        }
        for (int i = 0; i < equationchar.length; i++) {
            char piece = equationchar[i];
            
            if (Importance(piece) > 0) {
                while (s.isEmpty() == false && Importance(s.peek()) >= Importance(piece)) {
                    result.append(s.pop());
                }
                s.push(piece);
            } else if (piece == ')') {
                char flag = s.pop();
                while (flag != '(') {
                    result.append(flag);
                    flag = s.pop();
                }
            } else if (piece == '('){
                s.push(piece);
            } else {
                result.append(piece);
            }
        }
        for (int i = 0; i < s.size(); i++) {
            result.append(s.pop());
        }
        return result.reverse();
    }
    
    // boolean demostration of precedence checking
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
    
    public String returnPrefixToInfix(String equation) {
        Stack<String> s = new Stack<>();
        
        for (int i = equation.length() - 1; i >= 0 ; i--) {
            char value = equation.charAt(i);
            if (Check(value)) {
                String one = s.pop();
                String two = s.pop();
                String temp = "("+one+value+two+")";
                s.push(temp);
            } else {
                s.push(value+"");
            }
        }
        String result = s.pop();
        return result;
    }
}
