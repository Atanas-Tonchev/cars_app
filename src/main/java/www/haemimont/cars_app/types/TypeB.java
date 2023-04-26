package www.haemimont.cars_app.types;
import www.haemimont.cars_app.model.Car;



public class TypeB extends Car{

    int id;
    public TypeB() {

    }

    public TypeB(int id,String newModel, int newYear, double newPrice) {
        this.id=id;
        super.model = newModel;
        super.year = newYear;
        super.price=newPrice/2;
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public String setModel(String model) {
        super.setModel(model);
        return model;
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public int setYear(int year) {
        super.setYear(year);
        return year;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price/2);
    }

    @Override
    public String toString() {
        return id + "." + " || " + model + " || " + year + " || " + price + " || " + " TypeB ||";
    }
}