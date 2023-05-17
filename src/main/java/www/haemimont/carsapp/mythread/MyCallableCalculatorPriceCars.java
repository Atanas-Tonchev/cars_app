package www.haemimont.carsapp.mythread;
import www.haemimont.carsapp.model.Car;
import java.util.List;
import java.util.concurrent.Callable;
public class MyCallableCalculatorPriceCars implements Callable<Double>{
    private final double param;
    private final int threadNum;
    private final List<Car> cars;

    public MyCallableCalculatorPriceCars(List<Car> cars,double param,int threadNum) {
        this.threadNum = threadNum;
        this.param = param;
        this.cars = cars;
    }

    @Override
    public Double call(){
            double sumPriceCars = 0;
            for (int i = 0; i < cars.size(); i++) {
                sumPriceCars += (cars.get(i).getPrice() * param / cars.size())/threadNum;
            }
        return sumPriceCars*threadNum;
    }
}