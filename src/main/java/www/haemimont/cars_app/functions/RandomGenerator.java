package www.haemimont.cars_app.functions;
import www.haemimont.cars_app.model.Car;
import www.haemimont.cars_app.types.TypeA;
import www.haemimont.cars_app.types.TypeB;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private static final double MIN_PRICE = 1000.00, MAX_PRICE = 200000.00;

    static String[] carsMake = {"Audi","BMW","Volvo","Mercedes","Peugeot","Citroen","Opel","Ford","Fiat","Alfa Romeo"
    ,"Aston Martin","Nissan","Kia","Honda","Renault","Chevrolet","Mitsubishi","Toyota"};


    public double getRandomPrice() {
        return Math.round(ThreadLocalRandom.current().nextDouble(MIN_PRICE, MAX_PRICE));
    }

    public int getRandomYear(int yearFrom,int yearTo) {
        return ThreadLocalRandom.current().nextInt(yearFrom, yearTo);
    }

    public String getRandomCarMake() {
        return carsMake[ThreadLocalRandom.current().nextInt(0, carsMake.length)];
    }

    public List<Car> generateCars(int count,int yearFrom,int yearTo,String model){
        List<Car> cars = new ArrayList<>();

        model = getRandomCarMake();

        for (int i = 0; i < count; i++){

            Random random = new Random();
            int number = random.nextInt(2);

            if(number>0){
                cars.add(new TypeA(model,getRandomYear(yearFrom,yearTo),getRandomPrice()));
            } else {
                cars.add(new TypeB(model,getRandomYear(yearFrom,yearTo), getRandomPrice()));
            }


            System.out.println(cars);
        }

        return cars;
    }


}
