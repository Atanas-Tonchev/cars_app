package www.haemimont.cars_app.functions;
import www.haemimont.cars_app.model.Car;
import www.haemimont.cars_app.myThread.MyCallable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calculator {
    private double averageSum;
    private final double param;
    private final int yearFrom;
    private final int yearTo;
    private final int count;

    public Calculator(int yearFrom, int yearTo, int count,double param) {
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.count = count;
        this.param = param;
    }

    RandomGenerator generator = new RandomGenerator();

    public double AverageSum(int threadNum){
        List<Car> cars = generator.generateCars(getYearFrom(),getYearTo(),getCount());

        if (threadNum == 1) {
            for (int i = 0; i < count; i++) {
                averageSum += cars.get(i).getPrice();
                averageSum = ((averageSum * getParam()) / getCount());
            }
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

        }else {
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
        }
        return averageSum;
    }
    public long ExecuteTime(long startTime,long endTime) {
        long execution;
        execution = endTime - startTime;
        return execution;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public int getCount() {
        return count;
    }

    public double getParam() {
        return param;
    }
}
