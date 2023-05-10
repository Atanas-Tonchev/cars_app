package www.haemimont.carsapp.model;


public class TypeB extends Car {
    public TypeB(String newModel, int newYear, double newPrice) {
        super(newModel, newYear, newPrice/2);
    }
}