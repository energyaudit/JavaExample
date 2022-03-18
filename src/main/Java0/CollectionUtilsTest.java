package main.Java0;

import java.util.List;
        import org.apache.commons.collections4.CollectionUtils;

public class CollectionUtilsTest  {
    public static void main(String[] args) {
        List<String> list = getList();
        System.out.println("Non-Empty List Check: " + checkNotEmpty1(list));
        System.out.println("Non-Empty List Check: " + checkNotEmpty1(list));
        System.out.println("Empty List Check: " + checkEmpty1(list));
        System.out.println("Empty List Check: " + checkEmpty1(list));
    }
    static List<String> getList() {
        return null;
    }
    static boolean checkNotEmpty1(List<String> list) {
        return !(list == null || list.isEmpty());
    }
    static boolean checkNotEmpty2(List<String> list) {
        return CollectionUtils.isNotEmpty(list);
    }

    static boolean checkEmpty1(List<String> list) {
        return (list == null || list.isEmpty());
    }
    static boolean checkEmpty2(List<String> list) {
        return CollectionUtils.isEmpty(list);
    }

}