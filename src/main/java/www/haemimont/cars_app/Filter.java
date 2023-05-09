package www.haemimont.cars_app;
import www.haemimont.cars_app.functions.Calculator;
import java.util.Scanner;
import java.util.concurrent.*;

public class Filter {


    public static void main(String[] args) throws InterruptedException, ExecutionException {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input Param:");
        double param = scanner.nextDouble();
        System.out.println("Please input Year From:");
        int yearF = scanner.nextInt();
        System.out.println("Please input Year To:");
        int yearT = scanner.nextInt();
        System.out.println("Please input Count:");
        int count = scanner.nextInt();
        System.out.println("Your results is: " + count + " cars");

        Calculator calculator = new Calculator(yearF,yearT,count,param);

        long start = System.currentTimeMillis();
        System.out.println("Average sum for single thread is: " +calculator.AverageMultiThreadSum(1));
        long end = System.currentTimeMillis();
        System.out.println("Execution time for single thread is: " +calculator.ExecuteTime(start,end)+ " ms");
        start = System.currentTimeMillis();
        System.out.println("Average sum for multi thread is: " +calculator.AverageMultiThreadSum(Runtime.getRuntime().availableProcessors()));
        end = System.currentTimeMillis();
        System.out.println("Execution time for multi thread is: " +calculator.ExecuteTime(start,end)+ " ms");

    }

}


