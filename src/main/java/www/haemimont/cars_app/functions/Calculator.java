package www.haemimont.cars_app.functions;

public class Calculator {


    public void AverageSingleThreadSum(double price,double param, int count) {
        // get the start time
        long start = System.currentTimeMillis();

        // call the method

        double sum = (price * param) / count;
        System.out.println("Single Thread average sum is: " + sum);

        // get the end time
        long end = System.currentTimeMillis();

        // execution time
        long execution = end - start;
        System.out.println("Execution time for Single: " + execution + " ms");
    }
}
