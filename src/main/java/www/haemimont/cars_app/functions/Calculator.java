package www.haemimont.cars_app.functions;

import java.util.ArrayList;
import java.util.Random;

public class Calculator {

    RandomGenerator generator = new RandomGenerator();

    public double AverageCalculatorPrice(){
        double sum = 0;
        ArrayList<Double> arrayList = generator.arrayListPrice();
        System.out.println(arrayList);
        for (int i=0; i<arrayList.size(); i++) {

            sum = arrayList.get(0)+arrayList.get(1)+arrayList.get(2)+
                    arrayList.get(3)+arrayList.get(4)+arrayList.get(5)+arrayList.get(6)+
                    arrayList.get(7)+arrayList.get(8)+arrayList.get(9)+arrayList.get(10)+
                    arrayList.get(11)+arrayList.get(12)+arrayList.get(13)+arrayList.get(14)+
                    arrayList.get(15)+arrayList.get(16)+arrayList.get(17)+arrayList.get(18)+
                    arrayList.get(19)/2;
        }
        System.out.println("Average sum is: "+sum);

        return sum;
    }
}
