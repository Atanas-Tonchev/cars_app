package www.haemimont.cars_app.myThread;

import www.haemimont.cars_app.functions.Calculator;
import www.haemimont.cars_app.functions.RandomGenerator;

import java.util.Scanner;

public class MyRunnable implements Runnable{
    private final int threadNum;
    private double param;
    private double price;
    private int count;


    public MyRunnable(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {


        // get the start time
        long start = System.currentTimeMillis();

        double averageSum = (price * param) /count;
        System.out.println("The Final price is: " + price);
        System.out.println("The Final Average Sum is: " + averageSum);


        for(int i=1; i<threadNum+1;i++) {

            double averageThreadSum = ((price / threadNum) * (param / threadNum)) / (count / threadNum);
            System.out.println("From Thread: " +i+ "\n" + "Price is: " + price/threadNum);
            System.out.println("Average sum result is: " + averageThreadSum);

        }




        // get the end time
        long end = System.currentTimeMillis();

        // execution time
        long execution = end - start;
        System.out.println("Execution time: " + execution + " ms");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void setParam(double param) {
        this.param = param;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
