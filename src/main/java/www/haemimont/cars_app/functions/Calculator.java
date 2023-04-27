package www.haemimont.cars_app.functions;


import www.haemimont.cars_app.model.Car;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    double sum1=0;
    int yearF;
    int yearT;
    int count;





    int threadNum = 2 /*ManagementFactory.getThreadMXBean().getThreadCount()*/;


    public void AverageSingleThreadSum(int yearF,int yearT,double param, int count) {
        RandomGenerator generator = new RandomGenerator();

        List<Car> cars = generator.generateCars(yearF,yearT,count);

        for (int i=0; i<cars.size();i++) {
            sum1 = (cars.get(i).getPrice() + sum1);
        }
        double sum = (sum1 * param) / count;
        System.out.println("Single Thread average sum is: " + sum);

    }

    public void AverageMultiThreadSum(int yearF,int yearT,double param, int count) {
        RandomGenerator generator = new RandomGenerator();

        List<Car> cars = generator.generateCars(yearF,yearT,count);

        for (int i=0; i<cars.size();i++) {
            sum1 = (cars.get(i).getPrice() + sum1);
        }

        for(int i=1; i<threadNum;i++) {
            double averageThreadSum = ((sum1*param)/count)/threadNum;
            System.out.println("Multi Thread average sum is: " + averageThreadSum);
        }

    }

    public void setYearF(int yearF) {
        this.yearF = yearF;
    }

    public void setYearT(int yearT) {
        this.yearT = yearT;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
