package www.haemimont.carsapp.functions;
import www.haemimont.carsapp.mythread.MyCallableCalculatorPriceCars;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class MultiThreadAverageSum {
    public double averageSumMultiThread(MyCallableCalculatorPriceCars callable, double param, int count, int threadNum){
        double averageSum = 0;
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        try {
            for (int i = 1; i <= threadNum; i++){
                Future<Double> future = executor.submit(callable);
                averageSum = (future.get()*param/count)/threadNum;
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        return averageSum*threadNum;
    }
}
