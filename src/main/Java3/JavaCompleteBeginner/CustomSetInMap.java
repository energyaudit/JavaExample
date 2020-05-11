package main.Java3.JavaCompleteBeginner;


import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class PersonSet {
    private int id;
    private String name;

    public PersonSet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "{ID is: " + id + "; name is: " + name + "}";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final PersonSet other = (PersonSet) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }


}


public class CustomSetInMap {

    public static void main(String[] args) {

        PersonSet p1 = new PersonSet(0, "Bob");
        PersonSet p2 = new PersonSet(1, "Sue");
        PersonSet p3 = new PersonSet(2, "Mike");
        PersonSet p4 = new PersonSet(1, "Sue");

        Map<PersonSet, Integer> map = new LinkedHashMap<PersonSet, Integer>();
        map.put(p1, 1);
        map.put(p2, 2);
        map.put(p3, 3);
        map.put(p4, 1);

        for (PersonSet key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        Set<PersonSet> set = new LinkedHashSet<PersonSet>();

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        System.out.println(set);
    }

}