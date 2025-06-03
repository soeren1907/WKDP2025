package homework8.Ex1;

import java.util.ArrayList;

public class ShapeStorage <T extends Shape> extends ArrayList<T> {

    public double getTotalArea() {
        double totalArea = 0;
        for (T shape : this){
            totalArea += shape.getArea();
        }
        return totalArea;
    }
    public void displayAllShapes(){
        for(Shape shape : this) {
            System.out.println(shape.toString()); // nur Ausgabe kein Rückgabetyp
        }
    }
    public <U extends T> void importLargeShapes(ShapeStorage<U> other, double minArea) {
        for(U shape : other){
            if(shape.getArea() >= minArea){
                this.add(shape);
            }
        }
    }

}
