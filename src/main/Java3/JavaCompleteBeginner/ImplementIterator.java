package main.Java3.JavaCompleteBeginner;

public class ImplementIterator {
    public static void main(String[] args){
        UrlLibrary urlLibrary=new UrlLibrary();
        for(String html:urlLibrary){
            System.out.println(html.length());

        }
    }
}
