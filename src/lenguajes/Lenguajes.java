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
        System.out.println("---Don't add spaces or letters---");
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
        String prefix = b.Prefix(equation).toString();
        String postfix = c.Postfix(equation);
        
        System.out.println(" ");
        
        // printing the results
        System.out.println("Polish Notation: " + queueToString(array));
        System.out.println("Postfix: " + postfix); //this one works
        System.out.println("Prefix: " + prefix);   // this one works
        System.out.println("Prefix to Infix: " + b.returnPrefixToInfix(prefix));    //this one works
        System.out.println("Postfix to Infix: " + c.returnPostfixToInfix(postfix)); // this one works
        System.out.println("TAC: ");
        u.Mainprocess(equation);
        
        System.out.println(" ");
        System.out.println("Created by -> DiracSpace");
        System.out.println("Github -> https://github.com/DiracSpace");
    }
    
    // Turn queue to string for presentation
    private static String queueToString(Queue<String> queue) {
        
        // using stringbuilder
        StringBuilder sb = new StringBuilder();
        
        queue.stream().forEach((item) -> {
            sb.append(item);
        });
        return sb.toString();
    }
}