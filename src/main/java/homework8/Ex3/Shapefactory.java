package homework8.Ex3;

import homework8.Ex1.Circle;
import homework8.Ex1.Rectangle;
import homework8.Ex1.Shape;

public class Shapefactory {

    public static Shape fromString(String input){
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        input = input.trim(); //entfernt alle Leerzeichen aus dem String

        if (input.startsWith("Circle:")) {
            // Beispiel: "Circle: radius=2.0"
            String[] parts = input.split("radius=");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid Circle format");
            }

            try {
                double radius = Double.parseDouble(parts[1].trim());
                return new Circle(radius);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid radius value");
            }

        } else if (input.startsWith("Rectangle:")) {
            // Beispiel: "Rectangle: width=3.0, length=4.0"
            try {
                String[] parts = input.split("[:,=]");
                if (parts.length != 5) {
                    throw new IllegalArgumentException("Invalid Rectangle format");
                }

                double width = Double.parseDouble(parts[2].trim());
                double length = Double.parseDouble(parts[4].trim());
                return new Rectangle(width, length);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid width or length value");
            }

        } else {
            throw new IllegalArgumentException("Unknown shape type");
        }

    }

}
