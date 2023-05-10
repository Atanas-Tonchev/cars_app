package www.haemimont.carsapp;
import www.haemimont.carsapp.functions.Calculator;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input Param:");
        double param = scanner.nextDouble();
        System.out.println("Please input Count:");
        int count = scanner.nextInt();
        System.out.println("Your results is: " + count + " cars");
        Calculator calculator = new Calculator(count,param);
        long start = System.currentTimeMillis();
        System.out.println("Average sum for single thread is: " +calculator.averageSum(1));
        long end = System.currentTimeMillis();
        System.out.println("Execution time for single thread is: " +calculator.ExecuteTime(start,end)+ " ms");
        start = System.currentTimeMillis();
        System.out.println("Average sum for multi thread is: "
                +calculator.averageSum(Runtime.getRuntime().availableProcessors()));
        end = System.currentTimeMillis();
        System.out.println("Execution time for multi thread is: " +calculator.ExecuteTime(start,end)+ " ms");
    }
}