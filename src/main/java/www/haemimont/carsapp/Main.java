package www.haemimont.carsapp;
import www.haemimont.carsapp.functions.MultiThreadAverageSum;
import www.haemimont.carsapp.functions.RandomGenerator;
import www.haemimont.carsapp.functions.SingleThreadAverageSum;
import www.haemimont.carsapp.model.Car;
import www.haemimont.carsapp.functions.CarAveragePriceCalculator;
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
        System.out.printf("Average sum for single thread is: %,.2f",
                new SingleThreadAverageSum().averageSumSingle(new CarAveragePriceCalculator(cars,param)));
        long end = System.currentTimeMillis();
        long execution = end-start;
        System.out.println("\n"+"Execution time for single thread is: " +execution+  " ms");
        start = System.currentTimeMillis();
        System.out.printf("Average sum for multi thread is: %,.2f",
                new MultiThreadAverageSum().averageSumMultiThread(cars,Runtime.getRuntime().availableProcessors(),param));
        end = System.currentTimeMillis();
        execution = end-start;
        System.out.println("\n"+"Execution time for multi thread is: " +execution+ " ms");
    }
}