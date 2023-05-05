package www.haemimont.cars_app.functions;
import www.haemimont.cars_app.model.Car;
import www.haemimont.cars_app.model.TypeA;
import www.haemimont.cars_app.model.TypeB;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private static final double MIN_PRICE = 1000.00, MAX_PRICE = 2000000.00;

    static String[] carsMake = {"Audi", "BMW", "Volvo", "Mercedes", "Peugeot", "Citroen", "Opel", "Ford", "Fiat", "Alfa Romeo"
            , "Aston Martin", "Nissan", "Kia", "Honda", "Renault", "Chevrolet", "Mitsubishi", "Toyota"};


    public double getRandomPrice() {
        return Math.round(ThreadLocalRandom.current().nextDouble(MIN_PRICE, MAX_PRICE));
    }

    public int getRandomYear(int yearFrom, int yearTo) {
        return ThreadLocalRandom.current().nextInt(yearFrom, yearTo);
    }

    public String getRandomCarMake() {
       return carsMake[ThreadLocalRandom.current().nextInt(0, carsMake.length)];

    }

    public List<Car> generateCars(int yearF, int yearT, int count) {

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Random random = new Random();
            int number = random.nextInt(2);
            if (number > 0) {
                cars.add(new TypeA(getRandomCarMake(), getRandomYear(yearF, yearT), getRandomPrice()));

            } else {
                cars.add(new TypeB(getRandomCarMake(), getRandomYear(yearF, yearT), getRandomPrice()));

            }

        }


        return cars;
    }
}
