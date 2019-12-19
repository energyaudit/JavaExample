package main.Java3.JavaCompleteBeginner;

public enum AnimalEnum {
    CAT("Fergus"), DOG("Fido"), MOUSE("Jerry");
     
    private String name;
     
    AnimalEnum(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
     
    public String toString() {
        return "This animal is called: " + name;
    }
}