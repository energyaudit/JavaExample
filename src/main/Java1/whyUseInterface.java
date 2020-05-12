package main.Java1;

/**
 * .Why do we use interface ?
 * It is used to achieve total abstraction.
 * Since java does not support multiple inheritance in case of class, but by using interface it can achieve multiple inheritance .
 * Team work,after design interface,each team member goto coding different classes of implement the interface
 * Interfaces are used to implement abstraction. So the question arises why use interfaces when we have abstract classes?
 * The reason is, abstract classes may contain non-final variables, whereas variables in interface are final, public and static.
 */

interface Vehicle {

    // all are the abstract methods.
    void changeGear(int a);
    void speedUp(int a);
    void applyBrakes(int a);
}

class Bicycle implements Vehicle{
    int speed;
    int gear;
    // to change gear
    @Override
    public void changeGear(int newGear){
        gear = newGear;
    }
    // to increase speed
    @Override
    public void speedUp(int increment){
        speed = speed + increment;
    }

    // to decrease speed
    @Override
    public void applyBrakes(int decrement){
        speed = speed - decrement;
    }

    public void printStates() {
        System.out.println("speed: " + speed
                + " gear: " + gear);
    }
}

class Bike implements Vehicle {
    int speed;
    int gear;
    // to change gear
    @Override
    public void changeGear(int newGear){
        gear = newGear;
    }
    // to increase speed
    @Override
    public void speedUp(int increment){
        speed = speed + increment;
    }
    // to decrease speed
    @Override
    public void applyBrakes(int decrement){
        speed = speed - decrement;
    }
    public void printStates() {
        System.out.println("speed: " + speed
                + " gear: " + gear);
    }
}
class GFG {
    public static void main (String[] args) {
        // creating an inatance of Bicycle
        // doing some operations
        Bicycle bicycle = new Bicycle();
        bicycle.changeGear(2);
        bicycle.speedUp(3);
        bicycle.applyBrakes(1);
        System.out.println("Bicycle present state :");
        bicycle.printStates();

        // creating instance of the bike.
        Bike bike = new Bike();
        bike.changeGear(1);
        bike.speedUp(4);
        bike.applyBrakes(3);
        System.out.println("Bike present state :");
        bike.printStates();
    }
}