package www.haemimont.cars_app.functions;


import www.haemimont.cars_app.types.TypeA;

public class Calculator {

    RandomGenerator generator = new RandomGenerator();

    public double Sum(int count,double param){

        double price = generator.getRandomPrice();
        System.out.println("Generated price: " +price);
        double sum = (price*param)/count;
        System.out.println("Sum: " +sum);
        return sum;

    }


}
