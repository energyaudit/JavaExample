package src.main.Java2;

import java.util.*;
/**
 * Created by byang on 2018-06-25.
 */
public class Java8LambdaForEach {
    public static void main(String args[]){
        List<String> list=new ArrayList<String>();
        list.add("Jai");
        list.add("Vivek");
        list.add("Mahesh");
        list.add("Vishal");
        list.add("Naren");
        list.add("Hemant");
        list.add("Vikas");
        list.add("Ajay\n");
        list.forEach(//Lambda for each
                (name)->System.out.println(name)
        );
//forEach list of objects
        class StudentLa{
            int rollNo;
            String name;

            public StudentLa(int rollNo, String name){
                super();
                this.rollNo = rollNo;
                this.name = name;
            }
        }
        List<StudentLa> listL1=new ArrayList<StudentLa>();
        //Adding Students
        listL1.add(new StudentLa(1,"Nidhi"));
        listL1.add(new StudentLa(3,"Parbhjot"));
        listL1.add(new StudentLa(2,"Amani"));
        System.out.println("Sorting on the basis of name...");

        // implementing lambda expression
        Collections.sort(listL1, (p1, p2) -> {//Lambda compare,(p1, p2) means take 2 parameters p1,p2
            return p1.name.compareTo(p2.name);
        });
        for(StudentLa student:listL1){
            System.out.println(student.rollNo+" "+student.name);
        }
        //forEach and Map
        Map<String, Integer> items1 = new HashMap<>();
        items1.put("A", 10);
        items1.put("B", 20);
        items1.put("C", 30);
        items1.put("D", 40);
        items1.put("E", 50);
        items1.put("F", 60);
        for (Map.Entry<String, Integer> entry : items1.entrySet()) {
            System.out.println("Item1 : " + entry.getKey() + " Count : " + entry.getValue());
        }
        //In Java 8, you can loop a List with forEach + lambda expression or method reference
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

//lambda
//Output : A,B,C,D,E
        items.forEach(item->System.out.println(item));

//Output : C
        items.forEach(item->{
            if("C".equals(item)){
                System.out.println(item);
            }
        });

//method reference
//Output : A,B,C,D,E
        items.forEach(System.out::println);

//Stream and filter
//Output : B
        items.stream()
                .filter(s->s.contains("B"))
                .forEach(System.out::println);
    }
}