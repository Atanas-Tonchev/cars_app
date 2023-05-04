package www.haemimont.cars_app;
import www.haemimont.cars_app.functions.Calculator;
import www.haemimont.cars_app.functions.RandomGenerator;
import www.haemimont.cars_app.model.Car;
import www.haemimont.cars_app.myThread.MyRunnable;

import java.util.List;
import java.util.Scanner;

public class Filter {


    public static void main(String[] args) throws InterruptedException {

        int threadNum = 0;
        for(threadNum = 1; threadNum<=Runtime.getRuntime().availableProcessors(); threadNum++){
           // System.out.println("Total Number of threads " + threadNum);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input Param:");
        double param = scanner.nextDouble();
        System.out.println("Please input Year From:");
        int yearF = scanner.nextInt();
        System.out.println("Please input Year To:");
        int yearT = scanner.nextInt();
        System.out.println("Please input Count:");
        int count = scanner.nextInt();
        RandomGenerator generator = new RandomGenerator();
        Calculator calculator = new Calculator();

        List<Car> cars = generator.generateCars(yearF,yearT,count);
        double pricesSum = 0;
        for (int i=0; i<count; i++){
            pricesSum += cars.get(i).getPrice();
        }
        calculator.AverageSingleThreadSum(pricesSum,param,count);

        MyRunnable r = new MyRunnable(threadNum, pricesSum, param, count);
        Thread t = new Thread(r);
        t.start();
        t.join();
        r.AverageSumExecutionTimeMultiThread();

    }
}

