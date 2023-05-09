package www.haemimont.cars_app.myThread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Double> {
    private final double sum;

    public MyCallable(double sum) {
        this.sum = sum;
    }

    @Override
    public Double call(){
        System.out.println(Thread.currentThread().getName());
        return sum;
    }

}
