package www.haemimont.carsapp.functions;
import www.haemimont.carsapp.mythread.MyCallableCalculatorPriceCars;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class SingleThreadAverageSum {
    public double averageSumSingle(MyCallableCalculatorPriceCars callable, double param, int count) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        double averageSum;
        try {
            Future<Double> future = executor.submit(callable);
            averageSum = (future.get() * param / count);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        return averageSum;
    }
}
