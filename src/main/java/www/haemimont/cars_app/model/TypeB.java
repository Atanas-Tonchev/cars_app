package www.haemimont.cars_app.model;


public class TypeB extends Car {

    public TypeB(String newModel, int newYear, double newPrice) {
        super(newModel, newYear, newPrice/2);
    }

}