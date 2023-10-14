
package module8.one;

/*

Chapter 30: Choose ONE from exercises 30.1 through 30.9

30.7 (FIND THE SMALLEST ELEMENT) - Rewrite Programming Exercise 7.9 using streams

*/


import java.util.Scanner;
import java.util.stream.DoubleStream;

public class ThirtyPointSeven {

    // Exercise 7.9 uses min(double[] array)
    public static double min(double[] array) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 numbers: ");

        int count = 1; 
        for (int i = 0; i < 10; i++) {
            System.out.print("#"+ count +":\t");
            double number = input.nextDouble();
            array[i] = number; 
            count++;
        }

        // of.(array) is for getting what values we are using
        // .min() gets the min value
        // orElse is there just in case there is no min found and the double min value will default to "0.0"
        double min = DoubleStream.of(array).min().orElse(0.0);

        return min;
    }

    public static void main(String[] args) {
        double[] array = new double[10];
        double minimum = min(array);
        
        System.out.println("SMALLEST ELEMENT:  " + minimum);
    }
}


