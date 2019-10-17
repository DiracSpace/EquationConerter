package lenguajes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class PolishNotationMethod {
    
    // check to see if it is an operator
    public static boolean Check(String str){
        try {
            Double.valueOf(str);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    // Infix to Polish Notation
    Queue<String>Process(String[] infix) {
        
        Map<String,Integer> priority = new HashMap<>();
        priority.put("/", 5);
        priority.put("*", 5);
        priority.put("+", 4);
        priority.put("-", 4);
        priority.put("(", 0);
        
        Queue<String> line =  new LinkedList<>();
        Stack<String> stack = new Stack<>();
        
        for(String digit: infix) {
            if ("(".equals(digit)) {
                stack.push(digit);
                continue;
            }
            if (")".equals(digit)) {
                while (!"(".equals(stack.peek())) {
                    line.add(stack.pop());
                }
                stack.pop();
                continue;
            }
            if (priority.containsKey(digit)) {
                while (!stack.empty() && priority.get(digit) <= priority.get(stack.peek())) {
                    line.add(stack.pop());
                }
                stack.push(digit);
                continue;
            }
            if (Check(digit)) {
                line.add(digit);
                continue;
            }
            throw new IllegalArgumentException("Not a correct data type");
        }
        while (!stack.isEmpty()) {
            line.add(stack.pop());
        }
        return line;
    }
}
