package main.Java0.Lombok;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @AllArgsConstructor generates a constructor requiring an argument for every field in the annotated class.
 * @NoArgsConstructor generates a default constructor with no parameters.
 * @RequiredArgsConstructor generates a constructor requiring an argument for the final and @NonNull fields.
 * Lombok can't call the super constructor unless it is a no-args constructor.
 */

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EmployeeExpanded {

    private String name;
    private int salary;
}
