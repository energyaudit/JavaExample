package main.Java0.Lombok.value.staticconstructor;

import lombok.Value;

@Value(staticConstructor = "of")
public class EmployeeValueLombok {

    private String name;
    private int salary;
}
