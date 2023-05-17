package www.haemimont.carsapp.mythread;
import www.haemimont.carsapp.model.Car;
import java.util.List;
import java.util.concurrent.Callable;
public class MyCallableCalculatorPriceCars implements Callable<Double>{
    private final int count;
    private final List<Car> cars;
    public MyCallableCalculatorPriceCars(List<Car> cars, int count) {
        this.count = count;
        this.cars = cars;
    }
    @Override
    public Double call(){
        double sumPriceCars = 0;
        for (int i = 0; i < count; i++) {
            double sum = cars.get(i).getPrice();
            sumPriceCars += sum;
        }
        System.out.println(Thread.currentThread().getName());
        return sumPriceCars;
    }
}