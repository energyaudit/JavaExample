package main.Java3.Junit4;
/**
 * From a given set of test classes, the Categories runner runs only the classes and methods that are
 * annotated with either the category given with the @IncludeCategory annotation or a subtype of that
 * category. Either classes or interfaces can be used as categories. Subtyping works,
 * so if you say @IncludeCategory(SuperClass.class), a test marked @Category({SubClass.class})
 * will be run.You can also exclude categories by using the @ExcludeCategory annotation
 * In JUnit, you need to create marker interfaces to represent the categories:
 */

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Junit4CategoryMethdLevel {
//@Category on method level
    @Category(PerformanceTests.class)
    @Test
    public void test_a_1() {
        assertThat(1 == 1, is(true));
    }

    @Test
    public void test_a_2() {
        assertThat(1 == 1, is(true));
    }

}
