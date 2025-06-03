package homework8.Ex2;

import homework8.Ex1.Circle;
import homework8.Ex1.Rectangle;
import homework8.Ex1.Shape;
import java.util.List;
import java.util.Map;
import java.util. ArrayList ;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList < >();
        shapes.add(new Circle (2.0));
        shapes.add(new Rectangle(3.0 , 4.0));
        shapes.add(new Circle(1.0));
        shapes.add(new Rectangle (5.0 , 5.0));
        shapes.add(new Circle (3.5));
        System.out.println (" All Shapes :");
        for (Shape shape : shapes) {
            System.out.println(shape );
        }
// filter shapes with area >= 15
        System.out.println ("\nShapes with area >= 15:");
        List <Shape > filtered = ShapeAnalyzer
                . filterByMinArea (shapes , 15);
        for (Shape shape : filtered) {
            System.out.println(shape );
        }
// find shape with max area
        Shape maxShape = ShapeAnalyzer
                . findShapeWithMaxArea (shapes );
        System.out.println ("\nShape with max area :");
        System.out.println(maxShape );
// group by type
        Map <String , List <Shape >> grouped = ShapeAnalyzer
                . groupByType (shapes );
// print
        System.out.println ("\nGrouped by type :");
        for (Map.Entry <String , List <Shape >> entry : grouped.entrySet ()) {
            System.out.println(entry.getKey() + ":");
            for (Shape shape : entry.getValue()) {
                System.out.println(" " + shape);
            }
        }
    }

    /*
    Why is it important to use the wildcard <? extends Shape> in the method signature instead
    of a non-generic parameter? Hint: Think invariance.

    Weil Generics invariant sind. Das bedeutet, dass ein List<Circle> ist kein Untertyp von List<Shape>, obwohl Circle ein Shape ist.
    Ohne <? extends Shape> könntest du z.B. keine List<Circle> an eine Methode übergeben, die List<Shape> erwartet.
    Die Wildcard erlaubt es, beliebige Unterklassen von Shape zu akzeptieren, und macht die Methode flexibel und typsicher.
    -> Wildcard erlaubt die Nutzung aller Formen von Shape ohne sie wäre man nur auf Shape beschränkt

    Explain the design choice of using <T extends Shape> in groupByType instead of a wildcard.

    <T extends Shape> wird statt ? extends Shape verwendet, weil damit der konkrete Typ erhalten bleibt. So kann die Methode eine typsichere Map zurückgeben (Map<String, List<T>>) und erlaubt das Hinzufügen von Objekten zur Liste.
    Mit ? extends Shape wäre das nicht möglich, da Wildcards nur lesend verwendet werden können und der Rückgabetyp nicht präzise wäre.
    -> Kurz: <T extends Shape> erlaubt sauberes Schreiben und präzise Rückgabe, ? extends Shape nur lesen ohne Typbindung.

     Explain the design choice to make the methods in ShapeAnalyzer static
     Die Methoden in ShapeAnalyzer sind static, weil sie keine Objektzustände benötigen, sondern nur mit den übergebenen Parametern arbeiten.
    So kann die Klasse als Hilfsklasse genutzt werden – ähnlich wie Math oder Collections – und man muss kein Objekt erzeugen, um die Methoden zu verwenden.

     -> Wdh. Merkmale statischer Methoden
     Gehören zur Klasse, nicht zum Objekt
    → Du kannst sie mit Klassenname.methode() aufrufen, ohne ein Objekt zu erstellen.

    Kein Zugriff auf this oder Instanzvariablen
    → Sie können nur auf andere statische Elemente zugreifen (z. B. static-Variablen oder -Methoden).

    Werden oft für Hilfsmethoden verwendet
    → z. B. Math.sqrt(...) oder Collections.sort(...).



     */
}

