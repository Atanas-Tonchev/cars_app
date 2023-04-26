package www.haemimont.cars_app.types;
import www.haemimont.cars_app.model.Car;

public class TypeA extends Car {
    int id;
    public TypeA(int id,String newModel, int newYear, double newPrice) {
        this.id=id;
        super.model = newModel;
        super.year = newYear;
        super.price=newPrice;
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    public TypeA() {
    }


    @Override
    public String toString() {
        return id + "." + " || " + model + " || " + year + " || " + price + " || " + " TypeA ||";
    }
}