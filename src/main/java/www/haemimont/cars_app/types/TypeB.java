package www.haemimont.cars_app.types;

import www.haemimont.cars_app.model.Car;


public class TypeB extends Car {

    public TypeB(String newModel, int newYear, double newPrice) {
        super(newModel, newYear, newPrice/2);
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public String setModel(String model) {
        return super.setModel(model);
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public int setYear(int year) {
        return super.setYear(year);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public String toString() {
        return "TypeB{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}