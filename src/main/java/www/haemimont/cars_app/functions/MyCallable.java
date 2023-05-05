package www.haemimont.cars_app.functions;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Double> {
    private double sum;
    public MyCallable(double sum) {
        this.sum = sum;
    }
    /*private final double param;
    private final int yearFrom;
    private final int yearTo;
    private final int count;
    Calculator calculator = new Calculator();



    public MyCallable(double param, int yearFrom, int yearTo, int count) {
        this.param = param;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.count = count;
    }*/

    @Override
    public Double call() {
        return sum;/*calculator.AverageThreadSum(param, yearFrom, yearTo, count);*/
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
