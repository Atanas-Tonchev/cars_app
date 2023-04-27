package www.haemimont.cars_app;
import www.haemimont.cars_app.functions.Calculator;
import www.haemimont.cars_app.functions.RandomGenerator;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
       /* MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();*/

        RandomGenerator generator = new RandomGenerator();
        Calculator calculator = new Calculator();
        //generator.generateCars();
        calculator.AverageSum();

    }
}
