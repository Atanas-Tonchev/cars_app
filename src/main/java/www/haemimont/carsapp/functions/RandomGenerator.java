package www.haemimont.carsapp.functions;
import www.haemimont.carsapp.model.Car;
import www.haemimont.carsapp.model.TypeA;
import www.haemimont.carsapp.model.TypeB;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private static final double MIN_PRICE = 1000.00, MAX_PRICE = 2000000.00;
    private static final int MIN_YEAR = 2000,MAX_YEAR = 2055;
    static String[] carsMake = {"Audi", "BMW", "Volvo", "Mercedes", "Peugeot", "Citroen", "Opel", "Ford", "Fiat", "Alfa Romeo"
            , "Aston Martin", "Nissan", "Kia", "Honda", "Renault", "Chevrolet", "Mitsubishi", "Toyota"};
    public double getRandomPrice() {
        return Math.round(ThreadLocalRandom.current().nextDouble(MIN_PRICE, MAX_PRICE));
    }
    public int getRandomYear() {
        return Math.round(ThreadLocalRandom.current().nextInt(MIN_YEAR, MAX_YEAR));
    }
    public String getRandomCarMake() {
       return carsMake[ThreadLocalRandom.current().nextInt(0, carsMake.length)];
    }
    public List<Car> generateCars(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Random random = new Random();
            int number = random.nextInt(2);
            if (number > 0) {
                cars.add(new TypeA(getRandomCarMake(), getRandomYear(), getRandomPrice()));
            } else {
                cars.add(new TypeB(getRandomCarMake(), getRandomYear(), getRandomPrice()));
            }
        }
        return cars;
    }
}
