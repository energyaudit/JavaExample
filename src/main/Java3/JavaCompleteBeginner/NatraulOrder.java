package main.Java3.JavaCompleteBeginner;


import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Collections;
        import java.util.List;
        import java.util.SortedSet;
        import java.util.TreeSet;

class PersonNaOrder implements Comparable<PersonNaOrder> {
    private String name;

    public PersonNaOrder(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        final PersonNaOrder other = (PersonNaOrder) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int compareTo(PersonNaOrder person) {
        int len1 = name.length();
        int len2 = person.name.length();

        if(len1 > len2) {
            return 1;
        }
        else if(len1 < len2) {
            return -1;
        }
        else {
            return name.compareTo(person.name);
        }
    }
}

public class NatraulOrder {

    public static void main(String[] args) {
        List<PersonNaOrder> list = new ArrayList<PersonNaOrder>();
        SortedSet<PersonNaOrder> set = new TreeSet<PersonNaOrder>();

        addElements(list);
        addElements(set);

        Collections.sort(list);

        showElements(list);
        System.out.println();
        showElements(set);
    }

    private static void addElements(Collection<PersonNaOrder> col) {
        col.add(new PersonNaOrder("Joe"));
        col.add(new PersonNaOrder("Sue"));
        col.add(new PersonNaOrder("Juliet"));
        col.add(new PersonNaOrder("Clare"));
        col.add(new PersonNaOrder("Mike"));
    }

    private static void showElements(Collection<PersonNaOrder> col) {
        for(PersonNaOrder element: col) {
            System.out.println(element);
        }
    }

}
