package main.Java2.factory1;
/**
 * Created by byang on 2018-12-30.
 */
public class ShapeTypeService {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        ShapeFct shape1 = shapeFactory.createShape("CIRCLE");//so for factory use interface as instance type only,
        // because you not know which exact class you will use untill you see the paramter passed to factory
        shape1.draw();
        ShapeFct shape2 = shapeFactory.createShape("RECTANGLE");//remember use interface as type,not class CircleFactory
        //as type
        shape2.draw();
        ShapeFct shape3 = shapeFactory.createShape("SQUARE");//remember use interface as type
        shape3.draw();
    }
}