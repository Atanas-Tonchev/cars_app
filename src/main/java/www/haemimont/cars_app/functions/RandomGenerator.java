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

    public void generateCars(){
        boolean quit = false;
        String toQuit;

        List<Car> cars = new ArrayList<>();


        // get the start time
        long start = System.currentTimeMillis();

        // call the method
        Scanner scanner = new Scanner(System.in);

        while (!quit) {

            System.out.println("Please input Param:");
            double param = scanner.nextDouble();
            System.out.println("Please input Year From:");
            int yearF = scanner.nextInt();
            System.out.println("Please input Year To:");
            int yearT = scanner.nextInt();
            System.out.println("Please input Model:");
            String model = scanner.next();
            System.out.println("Please input Count:");
            int count = scanner.nextInt();

                 for (int i = 0; i < count; i++){
                     model = getRandomCarMake();
                     Random random = new Random();
                     int number = random.nextInt(2);
                        if(number>0){
                            cars.add(new TypeA(model,getRandomYear(yearF,yearT),getRandomPrice()));
                        } else {
                            cars.add(new TypeB(model,getRandomYear(yearF,yearT), getRandomPrice()));
                        }
                    }

            System.out.println("Your results is: " +cars);

            // get the end time
            long end = System.currentTimeMillis();

            // execution time
            long execution = end - start;
            System.out.println("Execution time: " + execution + " ms");
            scanner.nextLine();
            System.out.println("Press 'Q' to quit or any key to continue");
            toQuit = scanner.next();
            if (toQuit.equalsIgnoreCase("Q"))
                quit = true;
        }
        scanner.close();
        System.out.println("Good Bye");
    }
}
