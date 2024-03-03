package DM10_1;
import java.util.Stack;
public class Posfix {
    private Stack<Character> stack = new Stack<>();
    private String infix;
    private StringBuilder ans = new StringBuilder();
    Posfix(String input){
        infix = input;
    }
    private int compareOper(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
    public void infixToPostfix(){
        System.out.println("----------Infix to Postfix---------");
        for (int i = 0; i < infix.length(); i++){
            char t = infix.charAt(i);
            if ((t >= '0' && t <= '9') || (t >= 'A' && t <= 'Z') || (t >= 'a' && t <= 'z')){
                ans.append(t);
            }
            else if (t == '('){
                stack.push(t);
            }
            else if (t == ')'){
                stack.push(t);
                while (stack.peek() != '('){
                    if (stack.pop() != ')'){
                        ans.append(stack.pop());
                    }
                }
                // pop '('
                stack.pop();
            }
            else{
                while (!stack.isEmpty() && compareOper(t) <= compareOper(stack.peek())) {
                    ans.append(stack.pop());
                }
                stack.push(t);
            }
            System.out.println("----------Round: " + i + "---------");
            System.out.println("CharAt: " + t);
            System.out.println("Stack: " + stack);
            System.out.println("Postfix: " + ans);
        }
        while (stack.isEmpty() == false) {
            ans.append(stack.pop());
        }
        System.out.println("Final Postfix: " + ans);
    }
}
