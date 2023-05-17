package www.haemimont.carsapp;
import www.haemimont.carsapp.functions.MultiThreadAverageSum;
import www.haemimont.carsapp.functions.RandomGenerator;
import www.haemimont.carsapp.functions.SingleThreadAverageSum;
import www.haemimont.carsapp.model.Car;
import www.haemimont.carsapp.mythread.MyCallableCalculatorPriceCars;

import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input Param:");
        double param = scanner.nextDouble();
        System.out.println("Please input Count:");
        int count = scanner.nextInt();
        System.out.println("Your results is: " + count + " cars");
        List<Car> cars = new RandomGenerator().generateCars(count);
        long start = System.currentTimeMillis();
        System.out.println("Average sum for single thread is: "
                +new SingleThreadAverageSum().averageSumSingle(new MyCallableCalculatorPriceCars(cars,param,1)));
        long end = System.currentTimeMillis();
        long execution = end-start;
        System.out.println("Execution time for single thread is: " +execution+  " ms");
        start = System.currentTimeMillis();
        System.out.println("Average sum for multi thread is: "
                +new MultiThreadAverageSum().averageSumMultiThread(cars,4,param));
        end = System.currentTimeMillis();
        execution = end-start;
        System.out.println("Execution time for multi thread is: " +execution+ " ms");
    }
}