package homework8.Ex2;

import homework8.Ex1.Shape;

import java.util.*;

public class ShapeAnalyzer {

    public static List<Shape> filterByMinArea(Collection<? extends Shape> shapes, double minArea) {
        // List returnList = new ArrayList(); -> raw type warning, nicht sauber, da Java keine Typprüfung mehr macht
        List <Shape> returnList = new ArrayList(); // -> es werden alle Elemente auf den Typ Shape hochgecastet
        for (Shape shape : shapes) { // kein Typparameter nötig, da Aufgabe List<Shape> als Rückgabewert fordert
            if (shape.getArea() >= minArea) {
                returnList.add(shape);
            }
        }
        return returnList;
    }

    public static Shape findShapeWithMaxArea(Collection<? extends Shape> shapes) {
        Shape maxArea = null;
        boolean first = true;
        for (Shape shape : shapes) {
            if (first){
                maxArea = shape;
                first = false;
            }else{
                if (shape.getArea() > maxArea.getArea()){
                    maxArea = shape;
                }
            }
        }
        return maxArea;
    }


    public static Shape findShapeWithMaxAreaAlt(Collection<? extends Shape> shapes) {
        Iterator<? extends Shape> iterator = shapes.iterator();
        // man ruft auf einer Collection wie List, ArrayList die Methode .iterator auf ,um ein Iterator Objekt zu bekommen, mit den du durch alle Elemente dieser Collection gehen kannst
        if (iterator.hasNext()){
            return null; //Falls, Collection leer wird abgebrochen
        }
        Shape maxArea = iterator.next();
        while (iterator.hasNext()){
            Shape current = iterator.next();
            if(current.getArea() > maxArea.getArea()){
                maxArea = current;
            }
        }
        return maxArea;
    }
    public static <T extends Shape> Map<String, List<T>> groupByType(Collection<T> shapes) { //Generischn -> Nutzen für beliebige Shape-Unterklassen (T steht für den Typen Circle..)
        Map<String, List<T>> groupedShapes = new HashMap<>(); // Ersellt eine neue Map, wo  String Name = Key, List = Liste von Objekten des jeweiligen Typs
        for (T shape : shapes) {
            String typeName = shape.getClass().getSimpleName(); // Holt den Typ als String -> Klassenanmen
            if (!groupedShapes.containsKey(typeName)) {
                groupedShapes.put(typeName, new ArrayList<>()); // Neue List für diesen Typ anlegen
            }else {
                groupedShapes.get(typeName).add(shape); // Holen list für den Typnamen und fügst aktuelles Shape hinzu
            }
        }
        return groupedShapes;
    }
}
