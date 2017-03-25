import java.util.Stack;

/**
 * Created by ulise on 24/03/2017.
 *
 *  Given an expression as string comprising of opening and closing characters of parentheses - (), curly braces - {}
 *  and square brackets - [], we need to check if paranthesis are adequatily closed or not.
 *
 *  Example - " ({})[()()] "  - adequatily closed
 *          - " {[)()} "      - NOT adequatily closed
 */
public class Paranthesis {
    public static void main(String[] args) {
        String myString = "{[[]()]}{()}";

        System.out.println("Your string: "+myString);
        checkClosing(myString);
    }

    private static void checkClosing(String myString) {
        Stack stack = new Stack();

        if ((myString.length() % 2 == 1) ||
            (myString.charAt(0) == '}') ||
            (myString.charAt(0) == ']') ||
            (myString.charAt(0) == ')'))
        {
            System.out.println("Paranthesis NOT adequatily closed");
        }
        else
        {
            for (int i = 0; i < myString.length(); i++) {
                if ((myString.charAt(i) == '{') || (myString.charAt(i) == '[') || (myString.charAt(i) == '('))
                {
                    stack.push(myString.charAt(i));
                }
                else if (!isPair((char)stack.peek(), myString.charAt(i)))
                {
                    System.out.println("Paranthesis NOT adequatily closed");
                    break;
                }
                else
                {
                    stack.pop();
                }
            }
            if (stack.empty())
                System.out.println("Paranthesis adequatily closed");
        }
    }

    private static boolean isPair(char p1, char p2){
        if (((p1 == '{')&&(p2 == '}')) ||
                ((p1 == '[')&&(p2 == ']')) ||
                ((p1 == '(')&&(p2 == ')')))
            return true;
        else
            return false;
    }
}
