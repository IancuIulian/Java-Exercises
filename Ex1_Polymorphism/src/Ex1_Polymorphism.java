import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ulise on 14/03/2017.
 *
 * User will give you the length of each side/no of sides
 * 1 side = Take that as the side of a square or radius of a circle
 * 2 sides = Length and breadth of rectangle
 * 3 sides = sides of a triangle
 * Any other number of sides - Invalid Input
 * Find the smallest, largest and average area.
 *
 * This exercises emphasizes on the power of polymorphism - we can call the getArea() method for every object inside the
 *                                                          ArrayList "list", it can be a Rectangle, Square, Circle or
 *                                                          Triangle; list.get(i).getArea() will return the area of the
 *                                                          "i"th element in the list, regardless of the Shape.
 */

public class Ex1_Polymorphism {

    public static void main(String[] args) {
        ArrayList<Shape> list = new ArrayList<>();

        while (true){ //continue to ask for new values
            int[] values = takeInput();
            processInput(values, list);
            int exit = Integer.parseInt(JOptionPane.showInputDialog("1  -  Stop?\n2  -  Continue?"));
            if (exit == 1){
                break;
            }
        }

        if (!list.isEmpty()){
            Shape minimum = list.get(0);
            Shape maximum = list.get(0);
            double areaSum = list.get(0).getArea();

            for (int i = 1; i < list.size(); i++) {
                if (Double.compare(list.get(i).getArea(), minimum.getArea()) == -1){
                    minimum = list.get(i);
                }
                if (Double.compare(list.get(i).getArea(), maximum.getArea()) == 1){
                    maximum = list.get(i);
                }
                areaSum += list.get(i).getArea();
            }
            JOptionPane.showMessageDialog(null,
                    "Smallest area: " + minimum+
                    "\nLargest area: " + maximum+
                    "\nAverage area: " + areaSum / list.size());
        }
    }

    public static int[] takeInput(){
        String input = JOptionPane.showInputDialog("Enter values:"+
                "\n1 value  - Side of Square / Radius of Circle;"+
                "\n2 values - Length & Breadth of Rectangle;"+
                "\n3 values - Sides of Triangle.");
        String[] inputs = input.split(" ");
        int[] values = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            values[i] = Integer.parseInt(inputs[i]);
        }
        return values;
    }

    public static void processInput(int[] values, ArrayList<Shape> list){
        switch(values.length){
            case 1:
                int choice = Integer.parseInt(JOptionPane.showInputDialog("1  -  Side of Square\n2  -  Radius of Circle"));
                if (choice == 1){
                    Square square = new Square(values[0]);
                    list.add(square);
                }
                else {
                    Circle circle = new Circle(values[0]);
                    list.add(circle);
                }
                break;
            case 2:
                Rectangle rectangle = new Rectangle(values[0], values[1]);
                list.add(rectangle);
                break;
            case 3:
                Triangle triangle = new Triangle(values[0], values[1], values[2]);
                list.add(triangle);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Too many values!");
                break;
        }
    }
}


class Shape{
    public double getArea(){
        return 0;
    }
}

class Rectangle extends Shape{
    double length;
    double breadth;

    Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double getArea() {
        return length * breadth;
    }

    @Override
    public String toString() {
        return "Rectangle [length="+length+"; breadth="+breadth+"] - area: "+getArea();
    }
}

class Square extends Rectangle{
    Square(double side){
        super(side, side);
    }

    @Override
    public String toString() {
        return "Square [side="+super.length+"] - area: "+getArea();
    }
}

class Circle extends Shape{
    int radius;

    Circle(int radius){
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius="+radius+"] - area: "+getArea();
    }
}

class Triangle extends Shape{
    double side1, side2, side3;

    Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter(){
        return side1 * side2 * side3;
    }
    @Override
    public double getArea(){
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    @Override
    public String toString() {
        return "Triangle [side1="+side1+"; side2="+side2+"; side3="+side3+"] - area: "+getArea();
    }
}