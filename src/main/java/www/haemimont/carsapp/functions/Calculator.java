package www.haemimont.carsapp.functions;
import www.haemimont.carsapp.model.Car;
import www.haemimont.carsapp.mythread.MyCallable;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class Calculator {
    private final double param;
    private final int count;
   private final List<Car> cars;
    public Calculator(double param, int count, List<Car> cars) {
        this.param = param;
        this.count = count;
        this.cars = cars;
    }
    public double averageSumMultiThread(int threadNum){
        double sumPriceCars = 0;
        for (int i = 0; i < count; i++) {
            double sum = cars.get(i).getPrice();
            sumPriceCars += sum;
        }
        double averageSum = 0;
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        try {
            for (int i = 1; i <= threadNum; i++){
                Future<List<Double>> future = executor.submit(new MyCallable(sumPriceCars));
                List<Double> myList = future.get();
                for (Double list : myList){
                    averageSum = (list*param/count)/i;
                }
                averageSum = averageSum*i;
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        return averageSum;
    }
    public double averageSumSingleThread(){
        double sumPrices = 0;
        for (int i = 0; i < count; i++) {
            double sum = cars.get(i).getPrice();
            sumPrices += sum;
        }
        double averageSum = 0;
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
                Future<List<Double>> future = executor.submit(new MyCallable(sumPrices));
                List<Double> myList = future.get();
                for (Double list : myList){
                    averageSum = (list*param/count);
                }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        return averageSum;
    }
}