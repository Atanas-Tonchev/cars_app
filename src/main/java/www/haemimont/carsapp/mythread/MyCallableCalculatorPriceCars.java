package www.haemimont.carsapp.mythread;
import www.haemimont.carsapp.model.Car;
import java.util.List;
import java.util.concurrent.Callable;
public class MyCallableCalculatorPriceCars implements Callable<Double>{
    private final double param;
    private final List<Car> cars;

    public MyCallableCalculatorPriceCars(List<Car> cars,double param) {
        this.param = param;
        this.cars = cars;
    }

    @Override
    public Double call(){
        double sumPriceCars = 0;
        for (int i = 0; i < cars.size(); i++) {
            double sum = cars.get(i).getPrice();
            sumPriceCars += sum;
        }
       // System.out.println(Thread.currentThread().getName());
        return sumPriceCars * param / cars.size();
    }
}