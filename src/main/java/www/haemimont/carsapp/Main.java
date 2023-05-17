package www.haemimont.carsapp;
import www.haemimont.carsapp.functions.Calculator;
import www.haemimont.carsapp.functions.RandomGenerator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input Param:");
        double param = scanner.nextDouble();
        System.out.println("Please input Count:");
        int count = scanner.nextInt();
        System.out.println("Your results is: " + count + " cars");
        Calculator calculator = new Calculator(param,count,new RandomGenerator().generateCars(count));
        long start = System.currentTimeMillis();
        System.out.println("Average sum for single thread is: "
                        +calculator.averageSumSingleThread());
        long end = System.currentTimeMillis();
        long execution = end-start;
        System.out.println("Execution time for single thread is: " +execution+  " ms");
        start = System.currentTimeMillis();
        System.out.println("Average sum for multi thread is: "
                +calculator.averageSumMultiThread(4));
        end = System.currentTimeMillis();
        execution = end-start;
        System.out.println("Execution time for multi thread is: " +execution+ " ms");
    }
}