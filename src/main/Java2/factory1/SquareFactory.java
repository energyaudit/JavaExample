package main.Java2.factory1;
/**
 * Created by byang on 2018-12-30.
 */
public class SquareFactory implements ShapeFct {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}