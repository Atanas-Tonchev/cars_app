package www.haemimont.carsapp.functions;
import www.haemimont.carsapp.model.Car;
import www.haemimont.carsapp.mythread.MyCallable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
public class Calculator {
    private final double param;
    private final int count;

    public Calculator(int count,double param) {
        this.count = count;
        this.param = param;
    }

    public double averageSum(int threadNum){
        List<Car> cars = new RandomGenerator().generateCars(count);
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += cars.get(i).getPrice();
        }
        double averageSum = sum * param / count;
            ExecutorService executor = Executors.newFixedThreadPool(threadNum);
            List<Future<Double>> myList = new ArrayList<>();
            for (int i = 1; i <= threadNum; i++) {
                Future<Double> future = executor.submit(new MyCallable(averageSum / threadNum));
                myList.add(future);
            }
            for (Future<Double> f : myList) {
                try {
                    averageSum = f.get() * threadNum;
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            executor.shutdown();
        return averageSum;
    }
    public long ExecuteTime(long startTime,long endTime) {
        long execution;
        execution = endTime - startTime;
        return execution;
    }
}