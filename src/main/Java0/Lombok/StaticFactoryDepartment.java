package main.Java0.Lombok;
/**
 * The @Value annotation includes the attribute staticConstructor. When set, Lombok makes the constructor private
 * and then creates a static factory method for constructing objects
 */

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
class StaticFactoryDepartment {

    private String location;
    private String employeeNumber;
}