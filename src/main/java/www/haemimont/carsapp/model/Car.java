package www.haemimont.carsapp.model;


public class Car {
    private final String model;
    private final int year;
    private final double price;
    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}