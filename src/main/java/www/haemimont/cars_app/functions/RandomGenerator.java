package www.haemimont.cars_app.functions;
import www.haemimont.cars_app.types.TypeA;
import www.haemimont.cars_app.types.TypeB;

import java.util.*;

public class RandomGenerator {

    TypeA typeA = new TypeA();
    TypeB typeB = new TypeB();
    static int number;
    static int year;
    static double price;
    static String[] carsMake = {"Audi","BMW","Volvo","Mercedes","Peugeot","Citroen","Opel","Ford","Fiat","Alfa Romeo"};
    public ArrayList<Double> arrayListPrice(){
        ArrayList<Double> arrayListPrice = new ArrayList<>();
        for(price = 10.000; price<=100.000; price+=9.8){
            Random random = new Random();
            number = 1+random.nextInt(1000000);
            typeA.setPrice(price);
            System.out.println("Type A price is: "+typeA.getPrice());
            typeB.setPrice(price);
            System.out.println("Type B price is: "+typeB.getPrice());
            arrayListPrice.add(typeA.getPrice());
            arrayListPrice.add(typeB.getPrice());

        }
        return arrayListPrice;
    }
    public Map<Integer,ArrayList> RandomGenerator(){
        Map<Integer,ArrayList> map = new HashMap<>();
        ArrayList<Integer> arrayListYear = new ArrayList<>();
        ArrayList<String> arrayListModel = new ArrayList<>();
        ArrayList<Double> arrayListPrice = new ArrayList<>();

        for(price = 10.000; price<50.000; price+=4.400){
            Random random = new Random();
            number = 1+random.nextInt(1000000);
            typeA.setPrice(price);
            System.out.println("Type A price is: "+typeA.getPrice());
            typeB.setPrice(price);
            System.out.println("Type B price is: "+typeB.getPrice());
            arrayListPrice.add(typeA.getPrice());
            arrayListPrice.add(typeB.getPrice());
            map.put(number,arrayListPrice);
        }

        for(int i=0; i<carsMake.length; i++){
            Random random = new Random();
            number = 1+random.nextInt(1000000);
            typeA.setModel(carsMake[i]);
            System.out.println("Type A model is: "+typeA.getModel());
            typeB.setModel(carsMake[i]);
            System.out.println("Type B model is: "+typeB.getModel());
            arrayListModel.add(typeA.getModel());
            arrayListModel.add(typeB.getModel());
            map.put(number,arrayListModel);

        }

        for (year = 2000 ;year <= 2023 ; year++) {

            Random random = new Random();
            number = 1+random.nextInt(1000000);
            typeA.setYear(year);
            System.out.println("Type A year is: "+typeA.getYear());
            typeB.setYear(year);
            System.out.println("Type B year is: "+typeB.getYear());
            arrayListYear.add(typeA.getYear());
            arrayListYear.add(typeB.getYear());
            map.put(number,arrayListYear);
        }

        System.out.println(map);
        return map;
    }
}
