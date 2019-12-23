package main.Java3.JavaCompleteBeginner;


public class PassingByValue {


    public static void main(String[] args) {
        PassingByValue app = new PassingByValue();

        //===========================================

        int value = 7;
        System.out.println("1. Value is: " + value);

        app.show(value);

        System.out.println("4. Value is: " + value);

        //===========================================
        System.out.println();
    }

        public void show( int value){
            System.out.println("2. Value is: " + value);

            value = 8;

            System.out.println("3. Value is: " + value);
        }


}


