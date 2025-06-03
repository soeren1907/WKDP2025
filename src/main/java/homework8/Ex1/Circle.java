package homework8.Ex1;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius; // Math.PI = Pi -> Area = Pi * r^2
    }

    @Override
    public String toString() {
        return "Cicle with radius " + radius;
    }
}
