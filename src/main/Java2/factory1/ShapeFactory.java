package main.Java2.factory1;

/**
 * Created by byang on 2018-12-30.
 */
public class ShapeFactory {

    public ShapeFct createShape(String shapeType){
        switch (shapeType) {
            case "CIRCLE":
                return new CircleFactory();
            case "RECTANGLE":
                return new RectangleFactory();
            case "SQUARE":
                return new SquareFactory();
            default:
                return null;
        }
    }
}