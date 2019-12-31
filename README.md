# EquationConverter
Give an infix expression and convert to postfix and prefix. Plus, I want to add Three Address Code Generation

# Demostration
Sample: 

---Don't add spaces or letters---
Input infix equation: 
(4+5)*(4-5)/(4*5)+(4/5)
 
Polish Notation: 45+45-*45*/45/+
Postfix: 45+45-*45*/45/+
Prefix: *+45/-45*45/45
Prefix to Infix: ((4+5)*((4-5)/(4*5)))
Postfix to Infix: (+(/54)(/(*54)(*(-54)(+54))))
TAC: 

Operators: 
Operator
Array location
+		2
*		5
-		8
/		11
*		14
+		17
/		20

Operators in order: 
Operator	Array location
*		5
/		11
*		14
/		20
+		2
-		8
+		17

Three Address Code

t1 = )*(
t2 = )/(
t3 = 4*5
t4 = 4/5
t5 = 4+5
t6 = 4-5
t7 = )+(
 
Created by -> DiracSpace
Github -> https://github.com/DiracSpace
