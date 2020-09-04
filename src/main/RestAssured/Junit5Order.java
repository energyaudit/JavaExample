package main.RestAssured;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Junit5Order{

    private int sum;

    @BeforeAll
    void init() {
        sum = 1;
    }

    @Test
    @Order(1)
    void firstTest() {
        sum += 2;
        assertEquals(3, sum);
    }

    @Test
    @Order(2)
    void secondTest() {
        sum += 3;
        assertEquals(6, sum);
    }

}