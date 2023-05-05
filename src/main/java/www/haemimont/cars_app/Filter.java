package www.haemimont.cars_app;
import www.haemimont.cars_app.functions.Calculator;
import www.haemimont.cars_app.functions.MyCallable;
import www.haemimont.cars_app.functions.RandomGenerator;
import www.haemimont.cars_app.myThread.MyRunnable;

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
        RandomGenerator generator = new RandomGenerator();
        Calculator calculator = new Calculator();

        long start = System.currentTimeMillis();
        double sum = calculator.AverageThreadSum(generator.generateCars(yearF,yearT,count),param,count);
        System.out.println("Average sum for single thread is: " +sum);
        long end = System.currentTimeMillis();
        System.out.println("Execution time for single thread is: " +calculator.ExecuteTime(start,end));
        start = System.currentTimeMillis();
        sum = calculator.HoldThread();
        System.out.println("Average sum for multi thread is: " +sum);
        end = System.currentTimeMillis();
        System.out.println("Execution time for multi thread is: " +calculator.ExecuteTime(start,end));


        /*ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        MyCallable task = new MyCallable(sum);
        Future<Double> future = executor.submit(task);
        MyRunnable runnable = new MyRunnable(future.get(), threadNum);
        Thread thread = new Thread(runnable);
        thread.start();

        for (threadNum=2; threadNum<=4; threadNum++) {
            runnable = new MyRunnable(future.get()/threadNum,threadNum);
            thread = new Thread(runnable);
            thread.start();
        }
        executor.shutdown();*/


    }

    public void setSum(double sum) {
    }
}


