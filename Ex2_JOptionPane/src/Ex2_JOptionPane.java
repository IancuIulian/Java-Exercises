import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by ulise on 01/03/2017.
 *
 *  Ask the user for input (numbers) using a dialog.
 *  Display the minimum, maximum and average of the entered numbers using a dialog.
 *  (We assume the user enters integer numbers, separated by spaces)
 */
public class Ex2_JOptionPane {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter numbers separated by spaces: ");

        String[] inputs = input.split(" ");

        ArrayList<Integer> numbers = new ArrayList<>();

        for (String item : inputs) {
            numbers.add(Integer.parseInt(item));
        }

        int minimum = minimum(numbers);
        int maximum = maximum(numbers);
        double average = average(numbers);

        JOptionPane.showMessageDialog(null,"Minimum: "+minimum
                                        + "\nMaximum: "+maximum
                                        + "\nAverage: "+average);
    }


    public static int minimum(ArrayList<Integer> nums){
        int min  = nums.get(0);
        for (int x : nums) {
            if (x < min){
                min = x;
            }
        }
        return min;
    }

    public static int maximum(ArrayList<Integer> nums){
        int max  = 0;
        for (int x : nums) {
            if (x > max){
                max = x;
            }
        }
        return max;
    }

    public static double average(ArrayList<Integer> nums){
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        return (double)sum/nums.size();
    }
}