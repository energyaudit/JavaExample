package main.Java3.JavaCompleteBeginner;


public class EnumType {

    public static void main(String[] args) {

        AnimalEnum animal = AnimalEnum.DOG;
        switch(animal) {
            case CAT:
                System.out.println("Cat");
                break;
            case DOG:
                System.out.println("Dog");
                break;
            case MOUSE:
                System.out.println("MOUSE");
                break;
            default:
                break;
        }

        System.out.println(AnimalEnum.DOG);
        System.out.println("Enum name as a string: " + AnimalEnum.DOG.name());

        System.out.println(AnimalEnum.DOG.getClass());

        System.out.println(AnimalEnum.DOG instanceof Enum);

        System.out.println(AnimalEnum.MOUSE.getName());

        AnimalEnum animal2 = AnimalEnum.valueOf("CAT");

        System.out.println(animal2);
    }

}