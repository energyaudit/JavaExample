package main.Java0;


import java.util.*;

/**
 * Created by byang on 1/19/2018.
 */
public class Switch
{
    public static void main(String[] args) {
        int number=20;
        switch(number){//switch on number
            case 10: System.out.println("10");break;
            case 20: System.out.println("20");break;
            case 30: System.out.println("30");break;
            default:System.out.println("Not in 10, 20 or 30");
        }

        String game = "java";
        switch(game){//switch on string
            case "sql":
                System.out.println("Learn sql");
                break;
            case "java":
                System.out.println("Learn java");
                break;
            case "angularjs":
                System.out.println("Learn angularjs");
        }
        //nested switch
        int x = 1, y = 2;

        // Outer Switch
        switch (x) {

            // If x == 1
            case 1:

                // Nested Switch

                switch (y) {

                    // If y == 2
                    case 2:
                        System.out.println( "Choice is 2");
                        break;

                    // If y == 3
                    case 3:
                        System.out.println( "Choice is 3");
                        break;
                }
                break;

            // If x == 4
            case 4:
                System.out.println( "Choice is 4");
                break;

            // If x == 5
            case 5:
                System.out.println( "Choice is 5");
                break;

            default:
                System.out.println( "Choice is other than 1, 2 3, 4, or 5");
                break;
        }

        List<String> collectionOfNames = Arrays.asList("john", "doe", "anne", "alex");
        Map<String,Object> response= new HashMap<>();
        print(collectionOfNames,"False",response);
        print(collectionOfNames,"True",response);
    }
    private static Map<String,Object> print(List<String> PrintNames, String lower,Map<String,Object> response){
      for(int i=0;i< PrintNames.size();i++){
          switch (lower){
              case "True":
                  System.out.println(PrintNames.get(i).toLowerCase());
                  response.put(String.valueOf(i),PrintNames.get(i).toLowerCase());
                  break;
              case "False":
                  System.out.println(PrintNames.get(i).toUpperCase());
                  response.put(String.valueOf(i),PrintNames.get(i).toUpperCase());
                  break;
          }
      }
      System.out.println(response);
      return response;

    }


    //END
}