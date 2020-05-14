package main.RestAssured;
import static main.util.unionOfArrays.union;

public class callUnionArray {
    public static void main(String[] args) {
        Integer[] inputArray1 = {2, 3, 4, 7, 1};//if use generic,make sure use
        Integer[] inputArray2 = {4, 1, 3, 5};
        Integer[] inputArray3 = {8, 4, 6, 2, 1};
        Integer[] inputArray4 = {7, 9, 4, 1};
        union(inputArray1, inputArray2, inputArray3, inputArray4);

        String[] inputArray5={ "Ruby", "C", "Python", "Java"};
        String[] inputArray6={ "kayak", "refer", "mom", "dog"};
        String[] inputArray7={"longest", "civic", "madam"};
        union(inputArray5, inputArray6, inputArray7);
    }
}
