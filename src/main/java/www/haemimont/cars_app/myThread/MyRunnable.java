package www.haemimont.cars_app.myThread;

import www.haemimont.cars_app.functions.RandomGenerator;

import java.util.Scanner;

public class MyRunnable implements Runnable{
    RandomGenerator generator = new RandomGenerator();
    @Override
    public void run() {
        // get the start time
        long start = System.currentTimeMillis();

        // call the method
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input Param:");
        double param = scanner.nextDouble();
        System.out.println("Please input Count:");
        int count = scanner.nextInt();
        double price = generator.getRandomPrice();
        System.out.println("Price is: " +price);
        double sum = (price*param)/count;
        System.out.println("Thread 1 sum: " +sum);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // get the end time
        long end = System.currentTimeMillis();

        // execution time
        long execution = end - start;
        System.out.println("Execution time: " + execution + " ms");

    }

    public static void main(String[] args) {

    }
}
