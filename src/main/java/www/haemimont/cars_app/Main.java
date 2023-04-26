package www.haemimont.cars_app;
import www.haemimont.cars_app.functions.Calculator;
import www.haemimont.cars_app.functions.RandomGenerator;
import www.haemimont.cars_app.types.TypeA;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        RandomGenerator generator = new RandomGenerator();
        // get the start time
        long start = System.currentTimeMillis();

        // call the method

        Calculator calculator = new Calculator();
        //calculator.AverageCalculatorPrice();
        generator.RandomGenerator();

        // get the end time
        long end = System.currentTimeMillis();

        // execution time
        long execution = end - start;
        System.out.println("Execution time: " + execution + " ms");
    }
}
