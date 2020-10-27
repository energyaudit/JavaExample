package main.Java3.JavaCompleteBeginner;

public class Car extends Machine {
    private String brand = null;
    private int doors = 0;
    @Override
    public void start() {
        System.out.println("Starting ignition...");
         
    }
     @Override
    public void doStuff() {
        System.out.println("Driving...");
    }
     @Override
    public void shutdown() {
        System.out.println("Switch off ignition.");
           
    }
    public String getBrand() { return this.brand; }
    public void   setBrand(String brand){ this.brand = brand;}

    public int  getDoors() { return this.doors; }
    public void setDoors (int doors) { this.doors = doors; }
 public void print(){
        System.out.println(getBrand());
        System.out.println(getDoors());
    }
}