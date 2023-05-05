package www.haemimont.cars_app.myThread;

import www.haemimont.cars_app.Filter;

import java.io.File;

public class MyRunnable implements Runnable {
    private final double sum;
    private final int threadNum;

    public MyRunnable(double sum,int threadNum) {
        this.sum = sum;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {

        /*if (threadNum==1){
            getSum();
        }

        if (threadNum!=1){
            double v = getSum() * threadNum;
        }*/
    }

    public double getSum() {
        return sum;
    }
}
