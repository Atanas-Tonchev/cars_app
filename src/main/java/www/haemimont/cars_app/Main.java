package www.haemimont.cars_app;
import www.haemimont.cars_app.functions.Calculator;
import www.haemimont.cars_app.functions.RandomGenerator;
import www.haemimont.cars_app.myThread.MyMultiThreadRunnable;
import www.haemimont.cars_app.myThread.MyRunnable;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

         System.out.println("Total Number of threads " + ManagementFactory.getThreadMXBean().getThreadCount());



        Scanner scanner = new Scanner(System.in);


        RandomGenerator generator = new RandomGenerator();


        System.out.println("Please input Param:");
        double param = scanner.nextDouble();
        System.out.println("Please input Year From:");
        int yearF = scanner.nextInt();
        System.out.println("Please input Year To:");
        int yearT = scanner.nextInt();
             /*System.out.println("Please input Model:");
            String model = scanner.next();*/
        System.out.println("Please input Count:");
        int count = scanner.nextInt();

        //generator.generateCars(yearF, yearT, count);
        Calculator calculator = new Calculator();
        calculator.setCount(count);
        calculator.setYearF(yearF);
        calculator.setYearT(yearT);


        MyMultiThreadRunnable myMultiThreadRunnable = new MyMultiThreadRunnable();
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.setYearF(yearF);
        myRunnable.setYearT(yearT);
        myRunnable.setCount(count);
        myRunnable.setParam(param);
        myMultiThreadRunnable.setYearF(yearF);
        myMultiThreadRunnable.setYearT(yearT);
        myMultiThreadRunnable.setCount(count);
        myMultiThreadRunnable.setParam(param);

        Thread thread = new Thread(myRunnable);
        Thread multiThread = new Thread(myMultiThreadRunnable);
        thread.start();
        multiThread.start();



    }
}

