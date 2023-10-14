// Ignore this java file, just testing something out


package module8.two;

import java.util.Set;
import java.util.TreeSet;

public class RandomNumbers {

    public static void main(String[] args) {

        Set<Double> mySet = new TreeSet<>();

        for (int i=0; i<9000000; i++) {
            mySet.add(Math.random());
        }

        
        double sum = mySet.stream().mapToDouble(Double::doubleValue).sum();
        
        System.out.println("Sum of all values: " + sum);

        
    }
    
}