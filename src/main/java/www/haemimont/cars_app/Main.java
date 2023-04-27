package www.haemimont.cars_app;
import www.haemimont.cars_app.functions.Calculator;
import www.haemimont.cars_app.functions.RandomGenerator;
import www.haemimont.cars_app.myThread.MyRunnable;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        System.out.println("Total Number of threads " + ManagementFactory.getThreadMXBean().getThreadCount());


        RandomGenerator generator = new RandomGenerator();
        Calculator calculator = new Calculator();
        //generator.generateCars();
        //calculator.AverageSum();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input Param:");
        double param = scanner.nextDouble();

        System.out.println("Please input Count:");
        int count = scanner.nextInt();

        double price = generator.getRandomPrice();



            MyRunnable myRunnable = new MyRunnable(ManagementFactory.getThreadMXBean().getThreadCount());
            Thread thread = new Thread(myRunnable);
            myRunnable.setCount(count);
            myRunnable.setParam(param);
            myRunnable.setPrice(price);
            thread.start();




    }
}
