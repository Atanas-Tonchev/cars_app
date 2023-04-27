package www.haemimont.cars_app;
import www.haemimont.cars_app.functions.Calculator;
import www.haemimont.cars_app.functions.RandomGenerator;
import www.haemimont.cars_app.myThread.MyRunnable;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {


        RandomGenerator generator = new RandomGenerator();
        Calculator calculator = new Calculator();
        //generator.generateCars();
        //calculator.AverageSum();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input Param:");
        double param = scanner.nextDouble();

        System.out.println("Please input Count:");
        int count = scanner.nextInt();

        System.out.println("Please input the number of threads you wanna do the job: ");
        int threadNum = scanner.nextInt();

        double price = generator.getRandomPrice();



            MyRunnable myRunnable = new MyRunnable(threadNum);
            Thread thread = new Thread(myRunnable);
            myRunnable.setCount(count);
            myRunnable.setParam(param);
            myRunnable.setPrice(price);
            thread.start();


    }
}
