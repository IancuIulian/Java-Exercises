import java.util.Scanner;

/**
 * Created by ulise on 22/03/2017.
 *
 *   Ask user for a number, then return the biggest power of 2 that you can fit inside that number
 *
 *   Example: For input "7" your output should be 2 (2^2 = 4)
 *                      "8"                       3 (2^3 = 8)
 */
public class Ex4_powOfTwo_Log2 {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter number: ");
        double number = userInput.nextDouble();

        System.out.println(biggestPowOfTwo(number));
    }

    public static int biggestPowOfTwo(double number){
        // Java function "Math.log()" works in natural base "e", to get from base e to base 2 use this formula:
        // Formula:  logb(n) = log(n) / log(b)
        double result = (Math.log(number) / Math.log(2));
        return (int)result;
    }
}
