package www.haemimont.cars_app.myThread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Double> {
    private final double sum;
    private final int numTask;
    public MyCallable(double sum,int numTask) {
        this.sum = sum;
        this.numTask = numTask;
    }

    @Override
    public Double call(){
        System.out.println(Thread.currentThread().getName());
        return sum;
    }

    public int getNumTask() {
        return numTask;
    }
}
