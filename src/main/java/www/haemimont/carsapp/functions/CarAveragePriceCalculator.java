package www.haemimont.carsapp.functions;
import www.haemimont.carsapp.model.Car;
import java.util.List;
import java.util.concurrent.Callable;
public class CarAveragePriceCalculator implements Callable<Double>{
    private final double param;
    private final List<Car> cars;

    public CarAveragePriceCalculator(List<Car> cars, double param) {
        this.param = param;
        this.cars = cars;
    }

    @Override
    public Double call(){
            double sumPriceCars = 0;
            for (int i = 0; i < cars.size(); i++) {
                sumPriceCars += (cars.get(i).getPrice() * param / cars.size());
            }
        return sumPriceCars;
    }
}