package main.Java0.Lombok.value;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EmployeeExpanded {

    private String name;
    private int salary;
}
