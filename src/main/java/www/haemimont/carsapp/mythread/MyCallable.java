package www.haemimont.carsapp.mythread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
public class MyCallable implements Callable<List<Double>> {
    private final double priceSumCars;
    public MyCallable(double priceSumCars) {
        this.priceSumCars = priceSumCars;
    }
    @Override
    public List<Double> call(){
        List<Double> list = new ArrayList<>();
        list.add(priceSumCars);
        return list;
    }
}