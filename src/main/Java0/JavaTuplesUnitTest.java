package main.Java0;

import org.javatuples.*;
import org.javatuples.Quartet;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaTuplesUnitTest {

    @SuppressWarnings("unused")//@SuppressWarnings,The primary and most important benefit of using
    // @SuppressWarnings Annotation is that if we stuck because of some known warning,
    // then this will ignore the warning and move ahead. E.g. – deprecated and unchecked warnings.
    @Test
    public void whenCreatingTuples_thenCreateTuples() {
        Pair<String, Integer> pair = new Pair<String, Integer>("This is a pair", 55);
        Triplet<String, Integer, Double> triplet = Triplet.with("hello", 23, 33.2);

        List<String> collectionOfNames = Arrays.asList("john", "doe", "anne", "alex");
        Quartet<String, String, String, String> quartet = Quartet.fromCollection(collectionOfNames);

        Pair<String, String> pairFromList = Pair.fromIterable(collectionOfNames, 2);

        String[] names = new String[] { "john", "doe", "anne" };
        Triplet<String, String, String> triplet2 = Triplet.fromArray(names);
    }

    @Test
    public void whenGetValuexFromTuples_thenRetriveValueWithType() {
        Quartet<String, Double, Integer, String> quartet = Quartet.with("john", 72.5, 32, "1051 SW");

        String name = quartet.getValue0();
        Integer age = quartet.getValue2();
        assertThat(name).isEqualTo("john");
        assertThat(age).isEqualTo(32);
    }

    @Test
    public void whenGetKeyValue_thenGetKeyValue() {
        KeyValue<Integer, String> keyValue = KeyValue.with(5, "F");
        Integer key = keyValue.getKey();
        String value = keyValue.getValue();

        assertThat(key).isEqualTo(5);
        assertThat(value).isEqualTo("F");
    }

    @Test
    public void whenGetLabelValue_thenGetLabelValue() {
        LabelValue<Integer, String> labelValue = LabelValue.with(5, "F");
        Integer key = labelValue.getLabel();
        String value = labelValue.getValue();

        assertThat(key).isEqualTo(5);
        assertThat(value).isEqualTo("F");
    }

    @Test
    public void whenGetValueFromTuples_thenRetriveValueWithoutType() {
        Quartet<String, Double, Integer, String> quartet = Quartet.with("john", 72.5, 32, "1051 SW");

        String name = (String) quartet.getValue(0);
        Integer age = (Integer) quartet.getValue(2);
        assertThat(name).isEqualTo("john");
        assertThat(age).isEqualTo(32);
    }

    @Test
    public void whenSetValueInTuple_thenGetANewTuple() {
        Pair<String, Integer> john = Pair.with("john", 32);
        Pair<String, Integer> alex = john.setAt0("alex");
        assertThat(john.toString()).isNotEqualTo(alex.toString());
    }

    @Test
    public void whenAddNewElement_thenCreateNewTuple() {
        Pair<String, Integer> pair1 = Pair.with("john", 32);
        Triplet<String, Integer, String> triplet1 = pair1.add("1051 SW");
        assertThat(triplet1.contains("john"));
        assertThat(triplet1.contains(32));
        assertThat(triplet1.contains("1051 SW"));

        Pair<String, Integer> pair2 = Pair.with("alex", 45);
        Quartet<String, Integer, String, Integer> quartet2 = pair1.add(pair2);
        assertThat(quartet2.containsAll(pair1));
        assertThat(quartet2.containsAll(pair2));

        Quartet<String, Integer, String, Integer> quartet1 = pair1.add("alex", 45);
        assertThat(quartet1.containsAll("alex", "john", 32, 45));

        Triplet<String, String, Integer> triplet2 = pair1.addAt1("1051 SW");
        assertThat(triplet2.indexOf("john")).isEqualTo(0);
        assertThat(triplet2.indexOf("1051 SW")).isEqualTo(1);
        assertThat(triplet2.indexOf(32)).isEqualTo(2);

        Unit<Integer> unit = pair1.removeFrom0();
        assertThat(unit.contains(32));
    }

    @Test
    public void whenCallingToList_thenReturnList() {
        Quartet<String, Double, Integer, String> quartet = Quartet.with("john", 72.5, 32, "1051 SW");
        List<Object> list = quartet.toList();
        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void whenCallingToArray_thenReturnArray() {
        Quartet<String, Double, Integer, String> quartet = Quartet.with("john", 72.5, 32, "1051 SW");
        Object[] array = quartet.toArray();
        assertThat(array.length).isEqualTo(4);
    }
    @Test
    public void quintetTest() {
        Quintet<Integer, String, String, Double, Boolean> quintet
                = Quintet.with(Integer.valueOf(1),
                "GeeksforGeeks",
                "A computer portal",
                Double.valueOf(20.18),
                true);
        //Getting Value
        System.out.println(quintet.getValue0());
        System.out.println(quintet.getValue2());
//Setting Quintet Value
        Quintet<Integer, String, String, Double,Boolean> otherQuintet
                = quintet.setAt3(2.018);
        System.out.println(otherQuintet);
        //Adding a value can be done with the help of addAtX() method, where X represents the index at which the
        // value is to be added. This method returns a Tuple of element one more than the called Tuple
        Sextet<Integer, String, String, Double, Boolean, Boolean> sextet
                = quintet.addAt5(false);
        System.out.println(sextet);

    }


}
