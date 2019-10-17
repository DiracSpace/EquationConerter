package lenguajes;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Lenguajes {
    
    public static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        // starting variable
        String equation;
        
        // user input
        System.out.println("---Don't add parenthesis or letters---");
        System.out.println("Input infix equation: ");
        equation = leer.next();
        
        // break down string to array of pieces
        char[] pieces = equation.toCharArray();
        
        String[] infixarray = new String[pieces.length];
        
        for (int i = 0; i < pieces.length; i++) {
            char temp = pieces[i];
            infixarray[i] = Character.toString(temp);
        }
        
        // variables 
        ArrayList<String> ar = new ArrayList<>();
        Queue<String> array = new PolishNotationMethod().Process(infixarray);
        TAC u = new TAC();
        PostfixMethods c = new PostfixMethods();
        PrefixMethods b = new PrefixMethods();
        
        System.out.println(" ");
        
        // printing the results
        System.out.println("Polish Notation: " + queueToString(array));
        System.out.println("Infix to Postfix: " + c.Postfix(equation));
        System.out.println("Infix to Prefix: " + b.Prefijo(equation));
        System.out.println("Código intermedio triplos: ");
        u.Mainprocess(equation);
    }
    
    // Turn queue to string for presentation
    private static String queueToString(Queue<String> queue) {
        
        // using stringbuilder
        StringBuilder sb = new StringBuilder();
        
        queue.stream().forEach((item) -> {
            sb.append(item);
        });
        
        // one way of doing this
        //queue.forEach((item) -> {
            //sb.append(item);
        //});
        
        return sb.toString();
    }
}