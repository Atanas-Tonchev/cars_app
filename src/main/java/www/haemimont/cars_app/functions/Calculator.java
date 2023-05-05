package www.haemimont.cars_app.functions;

import www.haemimont.cars_app.model.Car;
import www.haemimont.cars_app.myThread.MyRunnable;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calculator {

    private double averageSum;
    private int threadNum;



    public double AverageThreadSum(List<Car> cars,double param, int count) throws ExecutionException, InterruptedException {
        threadNum = 1;
            double pricesSum = 0;
            for (int i = 0; i < count; i++) {
                pricesSum += cars.get(i).getPrice();
                averageSum = ((pricesSum * param) / count);
            }

       /* ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        MyCallable task = new MyCallable(averageSum);
        Future<Double> future = executor.submit(task);
        MyRunnable runnable = new MyRunnable(future.get(), threadNum);
        Thread thread = new Thread(runnable);
        thread.start();

        for (threadNum=2; threadNum<=4; threadNum++) {
            runnable = new MyRunnable(future.get()/threadNum,threadNum);
            thread = new Thread(runnable);
            thread.start();
        }
        executor.shutdown();
*/
        return averageSum;
    }
    public double HoldThread() throws ExecutionException, InterruptedException {

        threadNum = 1;
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        MyCallable task = new MyCallable(this.averageSum);
        Future<Double> future = executor.submit(task);
        MyRunnable runnable = new MyRunnable(future.get(), threadNum);
        Thread thread = new Thread(runnable);
        thread.start();

        for (threadNum=2; threadNum<=4; threadNum++) {
            runnable = new MyRunnable(future.get()/threadNum,threadNum);
            thread = new Thread(runnable);
            thread.start();
        }
        executor.shutdown();

        return averageSum;
    }
    public long ExecuteTime(long startTime,long endTime) {
        long execution = 0;
        execution = endTime - startTime;
        return execution;
    }

}
