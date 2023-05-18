package www.haemimont.carsapp.functions;
import www.haemimont.carsapp.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class MultiThreadAverageSum {
    public double averageSumMultiThread(List<Car> cars, int threadNum,double param){
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        List<Future<Double>> doubleFuture = new ArrayList<>();
        int size = cars.size()/threadNum;
        for (int start = 0; start < cars.size(); start += size) {
            int end = Math.min(start + size, cars.size());
            List<Car> sublist = cars.subList(start, end);
            doubleFuture.add(executor.submit(new CarAveragePriceCalculator(sublist,param)));
        }
        double averageSum = 0;
        for (Future<Double> f : doubleFuture){
            try {
                averageSum += f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
        return averageSum/threadNum;
    }
}
