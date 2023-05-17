package www.haemimont.carsapp.functions;
import www.haemimont.carsapp.model.Car;
import www.haemimont.carsapp.mythread.MyCallableCalculatorPriceCars;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class MultiThreadAverageSum {
    public double averageSumMultiThread(List<Car> cars, int threadNum,double param){
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        List<Future<Double>> list = new ArrayList<>();
        for (int i = 1; i <= threadNum; i++) {
            list.add(executor.submit(new MyCallableCalculatorPriceCars(cars,param,i)));
        }
        double averageSum = 0;
        for (Future f : list) {
            try {
                 averageSum = (double) f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
        return averageSum;
    }
}
