package www.haemimont.cars_app.myThread;


public class MyRunnable implements Runnable{

    private final int threadNum;
    private final double priceMulti;
    private final double param;
    private final int count;
    private double sum;


    public MyRunnable(int threadNum, double priceMulti, double param, int count) {
        this.threadNum = threadNum;
        this.priceMulti = priceMulti;
        this.param = param;
        this.count = count;
    }
    // get the start time
    long start = System.currentTimeMillis();

    // call the method

    @Override
    public void run() {

        sum = ((priceMulti/threadNum)*(param))/(count);


        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

    }

    public double getSum() {
        return sum;
    }

    public void AverageSumExecutionTimeMultiThread(){

        // get the end time
        long end = System.currentTimeMillis();

        // execution time
        long execution = end - start;
        System.out.println("Multi Thread average sum is: " +getSum()*threadNum);
        System.out.println("Execution time for Multi Thread: " + execution *threadNum + " ms");
    }

}
