package www.haemimont.cars_app;
import www.haemimont.cars_app.functions.Calculator;
import www.haemimont.cars_app.functions.RandomGenerator;
import www.haemimont.cars_app.myThread.MyRunnable;
import www.haemimont.cars_app.types.TypeA;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        RandomGenerator generator = new RandomGenerator();
        Calculator calculator = new Calculator();
        boolean quit = false;
        String toQuit;
        // get the start time
        long start = System.currentTimeMillis();

        // call the method
        Scanner scanner = new Scanner(System.in);
        while (!quit) {

            System.out.println("Please input Param:");
            double param = scanner.nextDouble();
            System.out.println("Please input Year From:");
            int yearF = scanner.nextInt();
            System.out.println("Please input Year To:");
            int yearT = scanner.nextInt();
            System.out.println("Please input Model:");
            String model = scanner.next();
            System.out.println("Please input Count:");
            int count = scanner.nextInt();
            System.out.println("Your results is: ");
            generator.generateCars(count,yearF,yearT,model);
            calculator.Sum(count,param);




            // get the end time
            long end = System.currentTimeMillis();

            // execution time
            long execution = end - start;
            System.out.println("Execution time: " + execution + " ms");
            scanner.nextLine();
            System.out.println("Press 'Q' to quit or any key to continue");
            toQuit = scanner.next();
            if (toQuit.equalsIgnoreCase("Q"))
                quit = true;


        }
        scanner.close();
        System.out.println("Good Bye");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();
    }
}
