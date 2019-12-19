package main.Java3.JavaCompleteBeginner;


public class InnerClass  {


    public static void main(String[] args) {

        Robot robot = new Robot(7);
        robot.start();

        // The syntax below will only work if Brain is
        // declared public. It is quite unusual to do this.
        // Robot.Brain brain = robot.new Brain();
        // brain.think();

        // This is very typical Java syntax, using
        // a static inner class.
        Robot.Battery battery = new Robot.Battery();
        battery.charge();
    }

}