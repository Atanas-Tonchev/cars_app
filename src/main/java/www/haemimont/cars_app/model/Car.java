package www.haemimont.cars_app.model;


public class Car {


    public String model;
    public int year;
    public  double price;


    public Car(String newModel, int newYear, double newPrice) {
        model = newModel;
        year = newYear;
        price = newPrice;
    }
    public String getModel() {
        return model;
    }

    public String setModel(String model) {
        this.model = model;
        return model;
    }

    public int getYear() {
        return year;
    }

    public int setYear(int year) {
        this.year = year;
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}