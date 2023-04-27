package www.haemimont.cars_app.myThread;

import www.haemimont.cars_app.functions.Calculator;
import www.haemimont.cars_app.functions.RandomGenerator;

import java.lang.management.ManagementFactory;

public class MyMultiThreadRunnable implements Runnable {

    Calculator calculator = new Calculator();
    private double param;
    private int count;
    private int yearF;
    private int yearT;

    @Override
    public void run() {
        // get the start time
        long start = System.currentTimeMillis();

        // call the method
        calculator.AverageMultiThreadSum(yearF,yearT,param,count);

        // get the end time
        long end = System.currentTimeMillis();

        // execution time
        long execution = end - start;
        System.out.println("Execution time for Multi Thread Average Sum: " + execution + " ms");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void setParam(double param) {
        this.param = param;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setYearF(int yearF) {
        this.yearF = yearF;
    }

    public void setYearT(int yearT) {
        this.yearT = yearT;
    }
}
