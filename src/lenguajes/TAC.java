package lenguajes;

public class TAC {
    
    private static final char[][] precedence = {
        {'/', '1'},
        {'*', '1'},
        {'+', '2'},
        {'-', '2'}
    };
    
    private static int importance(String value) {
        char token = value.charAt(0);
        for (char[] precedence1 : precedence) {
            if (token == precedence1[0]) {
                return Integer.parseInt(precedence1[1] + "");
            }
        }
        return -1;
    }
    
    public void Mainprocess(String equation) {
        int opc = 0, i, j;
        char token;
        boolean procesado[];
        String[][] operadores = new String[10][2];
        String temp;
        
        procesado = new boolean[equation.length()];
        
        for (i = 0; i < procesado.length; i++) {
            procesado[i] = false;
        }
        
        for (i = 0; i < equation.length(); i++) {
            token = equation.charAt(i);
            
            for (j = 0; j < precedence.length; j++) {
                if (token == precedence[j][0]) {
                    operadores[opc][0] = token + "";
                    operadores[opc][1] = i + "";
                    
                    opc++;
                    break;
                }
            }
        }
        
        System.out.println("\nOperators: \nOperator\nArray location");
        
        for (i = 0; i < opc; i++) {
            System.out.println(operadores[i][0] + "\t\t" + operadores[i][1]);
        }
        
        for (i = opc - 1; i >= 0; i--) {
            for (j = 0; j < i; j++) {
                if (importance(operadores[j][0]) > importance(operadores[j + 1][0])) {
                    temp = operadores[j][0];
                    operadores[j][0] = operadores[j + 1][0];
                    operadores[j + 1][0] = temp;
                    temp = operadores[j][1];
                    operadores[j][1] = operadores[j + 1][1];
                    operadores[j + 1][1] = temp;
                }
            }
        }
        
        System.out.println("\nOperators in order: \nOperator\tArray location");
        
        for (i = 0; i < opc; i++) {
            System.out.println(operadores[i][0] + "\t\t" + operadores[i][1]);
        }
        
        System.out.println("\nThree Address Code\n");
        
        for (i = 0; i < opc; i++) {
            j = Integer.parseInt(operadores[i][1] + "");
            
            String op1 = "", op2 = "";
            
            if (procesado[j - 1] == true) {
                if (importance(operadores[i - 1][0]) == importance(operadores[i][0])) {
                    op1 = "t" + i;
                } else {
                    for (int x = 0; x < opc; x++) {
                        if ((j - 2) == Integer.parseInt(operadores[x][1])) {
                            op1 = "t" + (x + 1) + "";
                        }
                    }
                }
            } else {
                op1 = equation.charAt(j - 1) + "";
            }
            
            if (procesado[j + 1] == true) {
                for (int x = 0; x < opc; x++) {
                    if ((j + 2) == Integer.parseInt(operadores[x][1])) {
                        op2 = "t" + (x + 1) + "";
                    }
                }
            } else {
                op2 = equation.charAt(j + 1) + "";
            }
            
            System.out.println("t" + (i + 1) + " = " + op1 + operadores[i][0] + op2);
            
            procesado[j] = procesado[j - 1] = procesado[j + 1] = true;
        }
    }
}
